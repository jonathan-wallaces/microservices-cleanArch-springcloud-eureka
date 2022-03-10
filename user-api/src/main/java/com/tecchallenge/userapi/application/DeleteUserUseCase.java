package com.tecchallenge.userapi.application;

import com.tecchallenge.userapi.application.port.out.UserPort;
import com.tecchallenge.userapi.core.UseCase;
import com.tecchallenge.userapi.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DeleteUserUseCase extends UseCase<DeleteUserUseCase.Inputvalues, DeleteUserUseCase.Outputvalues> {
    private final UserPort userPort;
    @Override
    @Transactional
    public Outputvalues execute(Inputvalues input) {
        User user = userPort.findUserById(input.getId());
        userPort.deleteUser(user);
        return Outputvalues.ofEmpty();
    }

    @Value
    public static class Inputvalues implements UseCase.InputValues{
        private Long id;
    }

    @Value
    public static class Outputvalues implements UseCase.OutputValues{

        public static Outputvalues ofEmpty() {
            return new Outputvalues();
        }
    }
}
