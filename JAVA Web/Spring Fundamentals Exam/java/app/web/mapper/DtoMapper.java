package app.web.mapper;

import app.user.model.User;
import app.web.dto.EditProfile;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DtoMapper {

    public static EditProfile mapUserToUserEditProfile(User user) {
        return EditProfile.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .profilePicture(user.getProfilePicture())
                .build();
    }
}
