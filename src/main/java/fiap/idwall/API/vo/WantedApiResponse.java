package fiap.idwall.API.vo;

import fiap.idwall.API.vo.dto.WantedApiResponseDto;

import java.util.List;

public class WantedApiResponse {
    private List<WantedApiResponseDto> items;

    public List<WantedApiResponseDto> getItems() {
        return items;
    }

    public void setItems(List<WantedApiResponseDto> items) {
        this.items = items;
    }
}
