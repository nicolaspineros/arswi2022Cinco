package co.escuelaing.edu;

import co.escuelaing.edu.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/")
public class WebSiteController {

    GameService gameService = GameService.getGame();

    @RequestMapping(value = "/game", method = RequestMethod.GET)
    public String inputGame(@RequestParam(value = "input") String input) {
        if (gameService.attempts == 0){
            return "ErrorAttempts";
        }else {
            String resp = gameService.tryNum(input);
            return resp;
        }
    }

    @PostMapping("/count")
    public void postAttempts(@RequestBody int count){
        System.out.println("Controller count:"+count);
        gameService.setAttempts(count);
    }


    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 36000;
    }
}
