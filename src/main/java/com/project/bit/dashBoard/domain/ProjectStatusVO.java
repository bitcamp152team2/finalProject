package com.project.bit.dashBoard.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ProjectStatusVO {
    private String projectStatusName;
    private int projectStatusAll;
    private int projectStatusProcess;
    private int projectStatusStandBy;
    private int projectStatusComplete;
    private int projectStatusStop;
}