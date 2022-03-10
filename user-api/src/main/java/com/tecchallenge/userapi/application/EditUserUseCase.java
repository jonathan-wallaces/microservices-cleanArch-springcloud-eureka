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
public class EditUserUseCase extends UseCase<EditUserUseCase.Inputvalues, UseCase.OutputValues> {
    private final UserPort userPort;

    @Override
    public UseCase.OutputValues execute(Inputvalues input) {
        User user = userPort.findUserById(input.getId());
        user.editUser(
          input.getName(),
          input.getCpf(),
          input.getEmail(),
          input.getPhoneNumber()
        );
        user.updatedAt();
        userPort.saveUser(user);
        return OutputValues.ofEmpty();
    }

    @Value
    public static class Inputvalues implements UseCase.InputValues{
        private Long id;
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
