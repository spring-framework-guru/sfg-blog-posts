@RestController
class DemoCLI {
    @RequestMapping("/get-message")
    String greetHello() {
        "Hi ! This is a message from groovy script"
    }
}