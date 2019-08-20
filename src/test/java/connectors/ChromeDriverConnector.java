package connectors;

import akka.actor.ActorSystem;
import akka.http.javadsl.Http;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.stream.ActorMaterializer;

import java.util.concurrent.ExecutionException;

public class ChromeDriverConnector {

    private ActorSystem actorSystem = ActorSystem.create();
    private ActorMaterializer actorMaterializer = ActorMaterializer.create(actorSystem);

    public String fetchLatestChromeDriverVersion(String baseUrl) throws ExecutionException, InterruptedException {
        HttpResponse httpResponse = Http
                .get(actorSystem)
                .singleRequest(
                        HttpRequest.create(baseUrl + "/LATEST_RELEASE"))
                .toCompletableFuture()
                .get();


        if (httpResponse.status().intValue() == 200) {
            return httpResponse.entity().getDataBytes().runFold("", (acc, dataString) -> acc + dataString.decodeString("UTF-8"), actorMaterializer).toCompletableFuture().get();
        } else {
            return null;
        }

    }

}
