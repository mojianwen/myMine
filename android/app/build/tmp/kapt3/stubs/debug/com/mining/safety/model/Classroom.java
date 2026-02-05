package com.mining.safety.model;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b/\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0012J\t\u00101\u001a\u00020\u0003H\u00c6\u0003J\t\u00102\u001a\u00020\u0005H\u00c6\u0003J\u000f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010H\u00c6\u0003J\t\u00104\u001a\u00020\u0005H\u00c6\u0003J\t\u00105\u001a\u00020\u0005H\u00c6\u0003J\t\u00106\u001a\u00020\u0005H\u00c6\u0003J\t\u00107\u001a\u00020\u0005H\u00c6\u0003J\t\u00108\u001a\u00020\u0005H\u00c6\u0003J\t\u00109\u001a\u00020\u0005H\u00c6\u0003J\t\u0010:\u001a\u00020\u000bH\u00c6\u0003J\t\u0010;\u001a\u00020\u000bH\u00c6\u0003J\t\u0010<\u001a\u00020\u000bH\u00c6\u0003J\u0087\u0001\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u00052\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0005H\u00c6\u0001J\t\u0010>\u001a\u00020\u000bH\u00d6\u0001J\u0013\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010BH\u00d6\u0003J\t\u0010C\u001a\u00020\u000bH\u00d6\u0001J\t\u0010D\u001a\u00020\u0005H\u00d6\u0001J\u0019\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\u000bH\u00d6\u0001R\u001e\u0010\u0011\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u000e\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001e\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001e\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u0016R$\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010\u0014\"\u0004\b(\u0010\u0016R\u001e\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010$\"\u0004\b*\u0010&R\u001e\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0014\"\u0004\b,\u0010\u0016R\u001e\u0010\r\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010$\"\u0004\b.\u0010&R\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0014\"\u0004\b0\u0010\u0016\u00a8\u0006J"}, d2 = {"Lcom/mining/safety/model/Classroom;", "Landroid/os/Parcelable;", "id", "", "name", "", "trainer", "location", "startTime", "endTime", "maxParticipants", "", "participantCount", "status", "description", "materialIds", "", "createTime", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getCreateTime", "()Ljava/lang/String;", "setCreateTime", "(Ljava/lang/String;)V", "getDescription", "setDescription", "getEndTime", "setEndTime", "getId", "()J", "getLocation", "setLocation", "getMaterialIds", "()Ljava/util/List;", "setMaterialIds", "(Ljava/util/List;)V", "getMaxParticipants", "()I", "setMaxParticipants", "(I)V", "getName", "setName", "getParticipantCount", "setParticipantCount", "getStartTime", "setStartTime", "getStatus", "setStatus", "getTrainer", "setTrainer", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_debug"})
@kotlinx.parcelize.Parcelize
public final class Classroom implements android.os.Parcelable {
    @com.google.gson.annotations.SerializedName(value = "id")
    private final long id = 0L;
    @com.google.gson.annotations.SerializedName(value = "name")
    @org.jetbrains.annotations.NotNull
    private java.lang.String name;
    @com.google.gson.annotations.SerializedName(value = "trainer")
    @org.jetbrains.annotations.NotNull
    private java.lang.String trainer;
    @com.google.gson.annotations.SerializedName(value = "location")
    @org.jetbrains.annotations.NotNull
    private java.lang.String location;
    @com.google.gson.annotations.SerializedName(value = "startTime")
    @org.jetbrains.annotations.NotNull
    private java.lang.String startTime;
    @com.google.gson.annotations.SerializedName(value = "endTime")
    @org.jetbrains.annotations.NotNull
    private java.lang.String endTime;
    @com.google.gson.annotations.SerializedName(value = "maxParticipants")
    private int maxParticipants;
    @com.google.gson.annotations.SerializedName(value = "participantCount")
    private int participantCount;
    @com.google.gson.annotations.SerializedName(value = "status")
    private int status;
    @com.google.gson.annotations.SerializedName(value = "description")
    @org.jetbrains.annotations.NotNull
    private java.lang.String description;
    @com.google.gson.annotations.SerializedName(value = "materialIds")
    @org.jetbrains.annotations.NotNull
    private java.util.List<java.lang.Long> materialIds;
    @com.google.gson.annotations.SerializedName(value = "createTime")
    @org.jetbrains.annotations.NotNull
    private java.lang.String createTime;
    
    public Classroom(long id, @org.jetbrains.annotations.NotNull
    java.lang.String name, @org.jetbrains.annotations.NotNull
    java.lang.String trainer, @org.jetbrains.annotations.NotNull
    java.lang.String location, @org.jetbrains.annotations.NotNull
    java.lang.String startTime, @org.jetbrains.annotations.NotNull
    java.lang.String endTime, int maxParticipants, int participantCount, int status, @org.jetbrains.annotations.NotNull
    java.lang.String description, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.Long> materialIds, @org.jetbrains.annotations.NotNull
    java.lang.String createTime) {
        super();
    }
    
    public final long getId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getName() {
        return null;
    }
    
    public final void setName(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTrainer() {
        return null;
    }
    
    public final void setTrainer(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getLocation() {
        return null;
    }
    
    public final void setLocation(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getStartTime() {
        return null;
    }
    
    public final void setStartTime(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getEndTime() {
        return null;
    }
    
    public final void setEndTime(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    public final int getMaxParticipants() {
        return 0;
    }
    
    public final void setMaxParticipants(int p0) {
    }
    
    public final int getParticipantCount() {
        return 0;
    }
    
    public final void setParticipantCount(int p0) {
    }
    
    public final int getStatus() {
        return 0;
    }
    
    public final void setStatus(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDescription() {
        return null;
    }
    
    public final void setDescription(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.Long> getMaterialIds() {
        return null;
    }
    
    public final void setMaterialIds(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.Long> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCreateTime() {
        return null;
    }
    
    public final void setCreateTime(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    public Classroom() {
        super();
    }
    
    public final long component1() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.Long> component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component6() {
        return null;
    }
    
    public final int component7() {
        return 0;
    }
    
    public final int component8() {
        return 0;
    }
    
    public final int component9() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.mining.safety.model.Classroom copy(long id, @org.jetbrains.annotations.NotNull
    java.lang.String name, @org.jetbrains.annotations.NotNull
    java.lang.String trainer, @org.jetbrains.annotations.NotNull
    java.lang.String location, @org.jetbrains.annotations.NotNull
    java.lang.String startTime, @org.jetbrains.annotations.NotNull
    java.lang.String endTime, int maxParticipants, int participantCount, int status, @org.jetbrains.annotations.NotNull
    java.lang.String description, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.Long> materialIds, @org.jetbrains.annotations.NotNull
    java.lang.String createTime) {
        return null;
    }
    
    @java.lang.Override
    public int describeContents() {
        return 0;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return null;
    }
    
    @java.lang.Override
    public void writeToParcel(@org.jetbrains.annotations.NotNull
    android.os.Parcel parcel, int flags) {
    }
}