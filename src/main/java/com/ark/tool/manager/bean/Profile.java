package com.ark.tool.manager.bean;
import lombok.Data;
import java.util.List;

@Data
public class Profile {
    public String ProfileId;
    public String ProfileName;
    public String InstallDirectory;
    public String AltSaveDirectoryName;
    public Boolean PGM_Enabled;
    public String PGM_Name;
    public String AdminPassword;
    public String ServerName;
    public String ServerArgs;
    public String ServerIP;
    public Integer ServerPort;
    public Integer QueryPort;
    public Boolean UseRawSockets;
    public Boolean RCONEnabled;
    public Integer RCONPort;
    public String ServerMap;
    public String ServerMapModId;
    public String TotalConversionModId;
    public List<String> ServerModIds;
    public Integer MotDDuration;
    public Boolean ForceRespawnDinos;

    public String BranchName;
    public String BranchPassword;

    public String SchedulerKey;
    public Boolean EnableAutoBackup;
    public Boolean EnableAutoUpdate;
    public Boolean EnableAutoShutdown1;
    public Boolean RestartAfterShutdown1;
    public Boolean UpdateAfterShutdown1;
    public Boolean EnableAutoShutdown2;
    public Boolean RestartAfterShutdown2;
    public Boolean UpdateAfterShutdown2;
    public Boolean AutoRestartIfShutdown;

    public Boolean SotFEnabled;

    public Integer MaxPlayerCount;

    public Boolean ServerUpdated;
    public String LastInstalledVersion;
}