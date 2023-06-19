package zerobase.wifi.service;


import zerobase.wifi.dto.PosHistoryDto;
import zerobase.wifi.model.PosHistoryModel;

public class PosHistoryService extends SqliteConnection {

    /**
     * 위경도 조회하는 히스토리 정보에 대한 기능을 구혀내 주세요.
     */

    public void save(PosHistoryModel posHistoryModel){
        PosHistoryDto posHistoryDto = new PosHistoryDto();
        posHistoryDto.insert(posHistoryModel);
    }


}
