package com.tecchallenge.userapi.application;

import com.tecchallenge.userapi.core.UseCase;
import com.tecchallenge.userapi.application.port.out.UserPort;
import com.tecchallenge.userapi.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SaveUserUseCase extends UseCase<SaveUserUseCase.Inputvalues, SaveUserUseCase.OutputValues> {
    private final UserPort userPort;

    @Override
    public OutputValues execute(Inputvalues input) {
        if(userPort.validateUser(input.getCpf())){
            throw new RuntimeException("User already exists");
        }
        else {
            User user = new User(
                    input.getName(),
                    input.getCpf(),
                    input.getEmail(),
                    input.getPhoneNumber()
            );
            user.createdAt();
            userPort.saveUser(user);
        }
        return OutputValues.ofEmpty();
    }

    @Value
    public static class Inputvalues implements UseCase.InputValues{
        private String name;
        private Long cpf;
        private String email;
        private Long phoneNumber;

    }

    @Value
    public static class OutputValues implements UseCase.OutputValues{
        public static OutputValues ofEmpty() {
            return new OutputValues();
        }
    }
}
