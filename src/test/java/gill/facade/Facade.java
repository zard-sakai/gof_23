package gill.facade;

public class Facade {

    private DbService dbService;
    private HttpService httpService;
    private RegistryService registryService;

    void handle(){
        dbService.process();
        httpService.handle();
        registryService.register();
    }

}
