package pl.edu.pja.hackathon.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.edu.pja.hackathon.services.TipService;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static com.google.common.io.ByteStreams.copy;

@Controller
@AllArgsConstructor
public class ImageTipController {

    private final TipService tipService;

    @GetMapping("tip/{id}/tipImage")
    public void renderImageFromDB(@PathVariable String id, HttpServletResponse response) throws IOException {
        var tip = tipService.getTipById(Long.valueOf(id));
        if (tip.getImage() != null) {
            byte[] byteArray = new byte[tip.getImage().length];
            int i = 0;

            for (Byte wrappedByte : tip.getImage()) {
                byteArray[i++] = wrappedByte; //auto unboxing
            }
            response.setContentType("image/jpeg");
            InputStream is = new ByteArrayInputStream(byteArray);
            copy(is, response.getOutputStream());
        }
    }
}
