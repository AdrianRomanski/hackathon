package pl.edu.pja.hackathon.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.edu.pja.hackathon.services.MemoCardService;
import pl.edu.pja.hackathon.services.UserService;

import javax.servlet.http.HttpServletResponse;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static com.google.common.io.ByteStreams.copy;

@Controller
@AllArgsConstructor
public class UserImageController {

    private final UserService userService;

    @GetMapping("user/{id}/userImage")
    public void renderImageFromDB(@PathVariable String id, HttpServletResponse response) throws IOException {
        var memoCard = userService.getUserByID(Long.valueOf(id));
        if (memoCard.getImage() != null) {
            byte[] byteArray = new byte[memoCard.getImage().length];
            int i = 0;

            for (Byte wrappedByte : memoCard.getImage()) {
                byteArray[i++] = wrappedByte; //auto unboxing
            }
            response.setContentType("image/jpeg");
            InputStream is = new ByteArrayInputStream(byteArray);
            copy(is, response.getOutputStream());
        }
    }
}
