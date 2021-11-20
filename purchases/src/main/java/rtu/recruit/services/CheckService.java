package rtu.recruit.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rtu.recruit.entities.CheckEntity;
import rtu.recruit.entities.CheckItemEntity;
import rtu.recruit.enums.PaymentType;
import rtu.recruit.exceptions.CheckDBException;
import rtu.recruit.exceptions.UserDBException;
import rtu.recruit.repos.CheckItemRepo;
import rtu.recruit.repos.CheckRepo;
import rtu.recruit.repos.ProductsRepo;
import rtu.recruit.repos.UserRepo;

import java.util.List;
import java.util.Map;

@Transactional
@Service
public class CheckService {
    @Autowired
    private CheckRepo checkRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ProductsRepo productsRepo;

    @Autowired
    private CheckItemRepo checkItemRepo;

    public List<CheckEntity> getAllChecksByUserId(long userId) {
        return checkRepo.findAllByUserId(userId);
    }

    @Transactional(readOnly = true)
    public List<CheckItemEntity> getAllCheckItemsByCheckId(long check_id) {
        return checkItemRepo.getAllByCheckId(check_id);
    }

    public List<CheckItemEntity> addItemToCheckOrCreateCheck(String body) throws JsonProcessingException, UserDBException {
        Map<String, String> bodyParams = new ObjectMapper().readValue(body, Map.class);
        long userId = Long.parseLong(bodyParams.get("user_id"));

        if (!userRepo.existsById(userId))
            throw new UserDBException("User not found");

        CheckItemEntity checkItem = new ObjectMapper().convertValue(
                bodyParams.get("item"), CheckItemEntity.class
        );

        CheckEntity check = initOrGetCheck(userId);
        checkItem = addCheckItemAndGetNewInstance(checkItem, check);

        return check.getItems();
    }

    private CheckEntity initOrGetCheck(long userId) {
        CheckEntity check = checkRepo.findFirstByUserIdAndNotClosed(userId);

        if (check == null) {
            check = new CheckEntity();
            check.setClosed(false);
            check.setUser(userRepo.findById(userId).get());
            check.setPayment(PaymentType.BILLS);
            check = checkRepo.save(check);
        }

        return check;
    }

    private CheckItemEntity addCheckItemAndGetNewInstance(CheckItemEntity checkItem, CheckEntity check) {
        checkItem.setCheck(check);
        checkItem.setCheckId(check.getId());
        checkItem = checkItemRepo.save(checkItem);
        check.addItem(checkItem);
        recomputeTotalCost(check);
        return checkItem;
    }

    @Transactional(readOnly = true)
    private void recomputeTotalCost(CheckEntity check) {
        List<CheckItemEntity> checkItemEntities = checkItemRepo.getAllByCheckId(check.getId());
        double total = checkItemEntities.stream()
                .mapToDouble(item ->
                        item.getCount() * productsRepo.getById(item.getProductId()).getCost()
                ).sum();
        check.setTotal(total);
    }

}
