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
public class ListAllUserUseCase extends UseCase<ListAllUserUseCase.Inputvalues, ListAllUserUseCase.OutputValues> {
    private final UserPort userPort;

    @Override
    public OutputValues execute(Inputvalues input) {
        List<User> users = userPort.findAllUsers();
        return OutputValues.of(users);
    }

    @Value
    public static class Inputvalues implements UseCase.InputValues{

    }

    @Value
    public static class OutputValues implements UseCase.OutputValues{
        List<User> users;
        public static OutputValues of(List<User> users) {
            return new OutputValues(users);
        }
    }
}
