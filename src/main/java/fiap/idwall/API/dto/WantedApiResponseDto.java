package fiap.idwall.API.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
public class WantedApiResponseDto {
        private String hair_raw;
        private String eyes_raw;

    public String getHair_raw() {
        return hair_raw;
    }

    public void setHair_raw(String hair_raw) {
        this.hair_raw = hair_raw;
    }

    public String getEyes_raw() {
        return eyes_raw;
    }

    public void setEyes_raw(String eyes_raw) {
        this.eyes_raw = eyes_raw;
    }
}
