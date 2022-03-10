package com.tecchallenge.userapi.application;

import com.tecchallenge.userapi.core.UseCase;
import com.tecchallenge.userapi.application.port.out.UserPort;
import com.tecchallenge.userapi.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ListUserByCpfUseCase extends UseCase<ListUserByCpfUseCase.InputValues, ListUserByCpfUseCase.OutputValues> {
    private final UserPort userPort;
    
    @Override
    public OutputValues execute(InputValues input) {
        List<User> usersList = List.of(userPort.findUserByCpf(input.getCpf()));
        if(usersList.isEmpty()){
            throw new RuntimeException("User not found!!!");
        }
        else{
            User user = usersList.stream().findFirst().get();
            return OutputValues.of(user);
        }

    }

    @Value
    public static class InputValues implements UseCase.InputValues{
        private Long cpf;
    }

    @Value
    public static class OutputValues implements UseCase.OutputValues{
        User user;
        public static ListUserByCpfUseCase.OutputValues of(User user) {
            return new ListUserByCpfUseCase.OutputValues(user);
        }
    }
}
