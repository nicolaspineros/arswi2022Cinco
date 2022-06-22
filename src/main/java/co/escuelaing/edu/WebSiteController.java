package co.escuelaing.edu;

import co.escuelaing.edu.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebSiteController {

    GameService gameService = new GameService();

    @RequestMapping(value = "/game", method = RequestMethod.GET)
    public String inputGame(@RequestParam(value = "input") String input) {
        if (gameService.attempts == 0){
            return "ErrorAttempts";
        }else {
            String resp = gameService.tryNum(input);
            return resp;
        }
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 36000;
    }
}
