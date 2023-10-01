package fiap.idwall.API.service;

import fiap.idwall.API.vo.WantedApiResponse;
import fiap.idwall.API.vo.dto.WantedApiResponseDto;
import fiap.idwall.API.model.Wanted;
import fiap.idwall.API.model.repository.WantedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class WantedService {

    @Autowired
    private WantedRepository wantedRepository;
    // Campo para manter o número da página atual
    private int currentPage = 1;
    public Wanted[] getByApiAndSave() {
        String apiUrl = "https://api.fbi.gov/wanted/v1/list?page=" + currentPage + "&pageSize=50";

        RestTemplate restTemplate = new RestTemplate();

        WantedApiResponse apiResponse = restTemplate.getForObject(apiUrl, WantedApiResponse.class);

        List<WantedApiResponseDto> apiWantedList = apiResponse.getItems();

        List<Wanted> wantedList = new ArrayList<>();

        for (WantedApiResponseDto apiWanted : apiWantedList) {
            Wanted wanted = new Wanted();
            wanted.setHair(apiWanted.getHair_raw());
            wanted.setEyes(apiWanted.getEyes_raw());
            wanted.setReward(apiWanted.getReward_max());
            wanted.setSex(apiWanted.getSex());
            wanted.setTitle(apiWanted.getTitle());
            wantedList.add(wanted);

            //wantedRepository.save(wanted);
        }

        wantedRepository.saveAll(wantedList);

        // Incrementa o número da página para a próxima chamada
        currentPage++;

        return wantedList.toArray(new Wanted[0]);
    }

}
