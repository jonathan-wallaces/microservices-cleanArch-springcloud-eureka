package com.tecchallenge.userapi.application;

import com.tecchallenge.userapi.application.port.out.UserPort;
import com.tecchallenge.userapi.core.UseCase;
import com.tecchallenge.userapi.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ListUserByIdUseCase extends UseCase<ListUserByIdUseCase.InputValues, ListUserByIdUseCase.OutputValues> {
    private final UserPort userPort;

    @Override
    public OutputValues execute(InputValues input) {
        User user = userPort.findUserById(input.getId());
        return ListUserByIdUseCase.OutputValues.of(user);
    }

    @Value
    public static class InputValues implements UseCase.InputValues{
        private Long id;
    }

    @Value
    public static class OutputValues implements UseCase.OutputValues{
        User user;
        public static ListUserByIdUseCase.OutputValues of(User user) {
            return new ListUserByIdUseCase.OutputValues(user);
        }
    }
}
