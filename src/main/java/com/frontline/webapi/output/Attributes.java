package com.frontline.webapi.output;

public class Attributes {
	
    private String lastLogin;
    private String previousLoginDate;
    private String notiSetting;
    private String settingAutoSaveSnapshotEnabled;
    private String settingConfirmSaveSnapshotEnabled;
    private String settingConfirmOpenInWhiteboard;
    private String translationEnabled;
    private String settingAutoLiveShareEnabled;

    public String getNotiSetting() {
		return notiSetting;
	}

	public void setNotiSetting(String notiSetting) {
		this.notiSetting = notiSetting;
	}

	public String getSettingAutoSaveSnapshotEnabled() {
		return settingAutoSaveSnapshotEnabled;
	}

	public void setSettingAutoSaveSnapshotEnabled(String settingAutoSaveSnapshotEnabled) {
		this.settingAutoSaveSnapshotEnabled = settingAutoSaveSnapshotEnabled;
	}

	public String getSettingConfirmSaveSnapshotEnabled() {
		return settingConfirmSaveSnapshotEnabled;
	}

	public void setSettingConfirmSaveSnapshotEnabled(String settingConfirmSaveSnapshotEnabled) {
		this.settingConfirmSaveSnapshotEnabled = settingConfirmSaveSnapshotEnabled;
	}

	public String getSettingConfirmOpenInWhiteboard() {
		return settingConfirmOpenInWhiteboard;
	}

	public void setSettingConfirmOpenInWhiteboard(String settingConfirmOpenInWhiteboard) {
		this.settingConfirmOpenInWhiteboard = settingConfirmOpenInWhiteboard;
	}

	public String getTranslationEnabled() {
		return translationEnabled;
	}

	public void setTranslationEnabled(String translationEnabled) {
		this.translationEnabled = translationEnabled;
	}

	public String getSettingAutoLiveShareEnabled() {
		return settingAutoLiveShareEnabled;
	}

	public void setSettingAutoLiveShareEnabled(String settingAutoLiveShareEnabled) {
		this.settingAutoLiveShareEnabled = settingAutoLiveShareEnabled;
	}

	public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getPreviousLoginDate() {
        return previousLoginDate;
    }

    public void setPreviousLoginDate(String previousLoginDate) {
        this.previousLoginDate = previousLoginDate;
    }
	    
}
