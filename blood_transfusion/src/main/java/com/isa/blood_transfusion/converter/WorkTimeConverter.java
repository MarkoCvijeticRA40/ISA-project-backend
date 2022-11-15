package com.isa.blood_transfusion.converter;

import com.isa.blood_transfusion.entity.WorkTimeEntity;
import com.isa.blood_transfusion.model.WorkTime;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class WorkTimeConverter {

    public WorkTime toModel(WorkTimeEntity workTimeEntity) {
        return new WorkTime(workTimeEntity.getId(), workTimeEntity.getStartTime(), workTimeEntity.getEndTime());
    }

    public Set<WorkTime> toModel(Set<WorkTimeEntity> workTimeEntities) {
        Set<WorkTime> workTimes = new HashSet<>();
        for (var w : workTimeEntities) {
            workTimes.add(new WorkTime(w.getId(), w.getStartTime(), w.getEndTime()));
        }

        return workTimes;
    }

    public WorkTimeEntity toEntity(WorkTime workTime) {
        return new WorkTimeEntity(workTime.getId(), workTime.getStartTime(), workTime.getEndTime());
    }

    public Set<WorkTimeEntity> toEntity(Set<WorkTime> workTimes) {
        Set<WorkTimeEntity> workTimeEntities = new HashSet<>();
        for (var w : workTimes) {
            workTimeEntities.add(new WorkTimeEntity(w.getId(), w.getStartTime(), w.getEndTime()));
        }

        return workTimeEntities;
    }
}
