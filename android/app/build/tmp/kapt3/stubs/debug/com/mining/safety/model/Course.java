package com.mining.safety.model;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b&\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Be\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u000fJ\t\u0010(\u001a\u00020\u0003H\u00c6\u0003J\t\u0010)\u001a\u00020\u0005H\u00c6\u0003J\t\u0010*\u001a\u00020\u0005H\u00c6\u0003J\t\u0010+\u001a\u00020\u0005H\u00c6\u0003J\t\u0010,\u001a\u00020\u0005H\u00c6\u0003J\t\u0010-\u001a\u00020\u0005H\u00c6\u0003J\t\u0010.\u001a\u00020\u000bH\u00c6\u0003J\u000f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00030\rH\u00c6\u0003J\t\u00100\u001a\u00020\u0005H\u00c6\u0003Ji\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\b\b\u0002\u0010\u000e\u001a\u00020\u0005H\u00c6\u0001J\t\u00102\u001a\u00020\u000bH\u00d6\u0001J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106H\u00d6\u0003J\t\u00107\u001a\u00020\u000bH\u00d6\u0001J\t\u00108\u001a\u00020\u0005H\u00d6\u0001J\u0019\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u000bH\u00d6\u0001R\u001e\u0010\u000e\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001e\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013R\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0011\"\u0004\b%\u0010\u0013R\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0011\"\u0004\b\'\u0010\u0013\u00a8\u0006>"}, d2 = {"Lcom/mining/safety/model/Course;", "Landroid/os/Parcelable;", "id", "", "name", "", "type", "duration", "trainer", "description", "status", "", "materialIds", "", "createTime", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/lang/String;)V", "getCreateTime", "()Ljava/lang/String;", "setCreateTime", "(Ljava/lang/String;)V", "getDescription", "setDescription", "getDuration", "setDuration", "getId", "()J", "getMaterialIds", "()Ljava/util/List;", "setMaterialIds", "(Ljava/util/List;)V", "getName", "setName", "getStatus", "()I", "setStatus", "(I)V", "getTrainer", "setTrainer", "getType", "setType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_debug"})
@kotlinx.parcelize.Parcelize
public final class Course implements android.os.Parcelable {
    @com.google.gson.annotations.SerializedName(value = "id")
    private final long id = 0L;
    @com.google.gson.annotations.SerializedName(value = "name")
    @org.jetbrains.annotations.NotNull
    private java.lang.String name;
    @com.google.gson.annotations.SerializedName(value = "type")
    @org.jetbrains.annotations.NotNull
    private java.lang.String type;
    @com.google.gson.annotations.SerializedName(value = "duration")
    @org.jetbrains.annotations.NotNull
    private java.lang.String duration;
    @com.google.gson.annotations.SerializedName(value = "trainer")
    @org.jetbrains.annotations.NotNull
    private java.lang.String trainer;
    @com.google.gson.annotations.SerializedName(value = "description")
    @org.jetbrains.annotations.NotNull
    private java.lang.String description;
    @com.google.gson.annotations.SerializedName(value = "status")
    private int status;
    @com.google.gson.annotations.SerializedName(value = "materialIds")
    @org.jetbrains.annotations.NotNull
    private java.util.List<java.lang.Long> materialIds;
    @com.google.gson.annotations.SerializedName(value = "createTime")
    @org.jetbrains.annotations.NotNull
    private java.lang.String createTime;
    
    public Course(long id, @org.jetbrains.annotations.NotNull
    java.lang.String name, @org.jetbrains.annotations.NotNull
    java.lang.String type, @org.jetbrains.annotations.NotNull
    java.lang.String duration, @org.jetbrains.annotations.NotNull
    java.lang.String trainer, @org.jetbrains.annotations.NotNull
    java.lang.String description, int status, @org.jetbrains.annotations.NotNull
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
    public final java.lang.String getType() {
        return null;
    }
    
    public final void setType(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDuration() {
        return null;
    }
    
    public final void setDuration(@org.jetbrains.annotations.NotNull
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
    public final java.lang.String getDescription() {
        return null;
    }
    
    public final void setDescription(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    public final int getStatus() {
        return 0;
    }
    
    public final void setStatus(int p0) {
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
    
    public Course() {
        super();
    }
    
    public final long component1() {
        return 0L;
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
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.Long> component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.mining.safety.model.Course copy(long id, @org.jetbrains.annotations.NotNull
    java.lang.String name, @org.jetbrains.annotations.NotNull
    java.lang.String type, @org.jetbrains.annotations.NotNull
    java.lang.String duration, @org.jetbrains.annotations.NotNull
    java.lang.String trainer, @org.jetbrains.annotations.NotNull
    java.lang.String description, int status, @org.jetbrains.annotations.NotNull
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