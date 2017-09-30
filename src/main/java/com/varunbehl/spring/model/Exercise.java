package com.varunbehl.spring.model;

public class Exercise {

	private String exceriseId;
	private String exceriseName;
	private String exerciseType;
	private String exerciseImages;
	private String exerciseVideoUrl;
	private String exerciseSubCategory;
	private Integer exerciseMinRep;
	private Integer exerciseMaxRep;
	private Integer exerciseSet;
	private Integer userLevel;

	public String getExceriseId() {
		return exceriseId;
	}

	public void setExceriseId(String exceriseId) {
		this.exceriseId = exceriseId;
	}

	public String getExceriseName() {
		return exceriseName;
	}

	public void setExceriseName(String exceriseName) {
		this.exceriseName = exceriseName;
	}

	public String getExerciseType() {
		return exerciseType;
	}

	public void setExerciseType(String exerciseType) {
		this.exerciseType = exerciseType;
	}

	public String getExerciseImages() {
		return exerciseImages;
	}

	public void setExerciseImages(String exerciseImages) {
		this.exerciseImages = exerciseImages;
	}

	public String getExerciseVideoUrl() {
		return exerciseVideoUrl;
	}

	public void setExerciseVideoUrl(String exerciseVideoUrl) {
		this.exerciseVideoUrl = exerciseVideoUrl;
	}

	public String getExerciseSubCategory() {
		return exerciseSubCategory;
	}

	public void setExerciseSubCategory(String exerciseSubCategory) {
		this.exerciseSubCategory = exerciseSubCategory;
	}

	public Integer getExerciseMinRep() {
		return exerciseMinRep;
	}

	public void setExerciseMinRep(Integer exerciseMinRep) {
		this.exerciseMinRep = exerciseMinRep;
	}

	public Integer getExerciseMaxRep() {
		return exerciseMaxRep;
	}

	public void setExerciseMaxRep(Integer exerciseMaxRep) {
		this.exerciseMaxRep = exerciseMaxRep;
	}

	public Integer getExerciseSet() {
		return exerciseSet;
	}

	public void setExerciseSet(Integer exerciseSet) {
		this.exerciseSet = exerciseSet;
	}

	public Integer getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(Integer userLevel) {
		this.userLevel = userLevel;
	}

}