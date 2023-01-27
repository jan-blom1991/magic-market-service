package com.jan.magicmarket.services;

import com.jan.magicmarket.config.rest.ResponseMessage;
import com.jan.magicmarket.config.rest.ResponseObject;
import com.jan.magicmarket.model.User;
import com.jan.magicmarket.repositories.AddressRepository;
import com.jan.magicmarket.repositories.CartRepository;
import com.jan.magicmarket.repositories.OrderRepository;
import com.jan.magicmarket.repositories.UserRepository;
import com.jan.magicmarket.transfer.TransferObject;
import com.jan.magicmarket.transfer.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService extends BaseService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CartRepository cartRepository;

    public ResponseObject<UserDetail> getUser(String emailAddress,
                                              String password) {

        User user = userRepository.findByEmailAddress(emailAddress).orElse(null);

        if (user == null) {
            return buildErrorResponse(ResponseMessage.USER_NOT_FOUND);
        } else if (!user.getPassword().equals(password)) {
            return buildErrorResponse(ResponseMessage.USER_PASSWORD_INVALID);
        }

        TransferObject<UserDetail> transferObject = transferObjectBuilder.generateUserDetail(user);
        return buildSuccessResponse(transferObject);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }
}
