package com.isa.blood_transfusion.converter;

import com.isa.blood_transfusion.entity.WorkTimeEntity;
import com.isa.blood_transfusion.model.WorkTime;
import org.springframework.stereotype.Component;

@Component
public class WorkTimeConverter {

    public WorkTime toModel(WorkTimeEntity workTimeEntity) {
        return new WorkTime(workTimeEntity.getId(), workTimeEntity.getStartTime(), workTimeEntity.getEndTime());
    }
}
