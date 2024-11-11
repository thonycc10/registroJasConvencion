package com.convenjasapi.convenjasapi.dto;

public class ParticipantDto {
    private Integer totalMember;
    private Integer totalInvitate;

    ParticipantDto(Integer totalMember, Integer totalInvitate) {}

    public Integer getTotalMember() {
        return totalMember;
    }

    public void setTotalMember(Integer totalMember) {
        this.totalMember = totalMember;
    }

    public Integer getTotalInvitate() {
        return totalInvitate;
    }

    public void setTotalInvitate(Integer totalInvitate) {
        this.totalInvitate = totalInvitate;
    }
}
