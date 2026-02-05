package com.mining.safety.model;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B3\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u00a2\u0006\u0002\u0010\u000bJ\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\bH\u00c6\u0003J\t\u0010\u0017\u001a\u00020\bH\u00c6\u0003J\t\u0010\u0018\u001a\u00020\bH\u00c6\u0003JG\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003J\t\u0010\u001d\u001a\u00020\bH\u00d6\u0001J\t\u0010\u001e\u001a\u00020\u001fH\u00d6\u0001R\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\n\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006 "}, d2 = {"Lcom/mining/safety/model/PageResponse;", "T", "", "records", "", "total", "", "size", "", "current", "pages", "(Ljava/util/List;JIII)V", "getCurrent", "()I", "getPages", "getRecords", "()Ljava/util/List;", "getSize", "getTotal", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "app_debug"})
public final class PageResponse<T extends java.lang.Object> {
    @com.google.gson.annotations.SerializedName(value = "records")
    @org.jetbrains.annotations.NotNull
    private final java.util.List<T> records = null;
    @com.google.gson.annotations.SerializedName(value = "total")
    private final long total = 0L;
    @com.google.gson.annotations.SerializedName(value = "size")
    private final int size = 0;
    @com.google.gson.annotations.SerializedName(value = "current")
    private final int current = 0;
    @com.google.gson.annotations.SerializedName(value = "pages")
    private final int pages = 0;
    
    public PageResponse(@org.jetbrains.annotations.NotNull
    java.util.List<? extends T> records, long total, int size, int current, int pages) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<T> getRecords() {
        return null;
    }
    
    public final long getTotal() {
        return 0L;
    }
    
    public final int getSize() {
        return 0;
    }
    
    public final int getCurrent() {
        return 0;
    }
    
    public final int getPages() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<T> component1() {
        return null;
    }
    
    public final long component2() {
        return 0L;
    }
    
    public final int component3() {
        return 0;
    }
    
    public final int component4() {
        return 0;
    }
    
    public final int component5() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.mining.safety.model.PageResponse<T> copy(@org.jetbrains.annotations.NotNull
    java.util.List<? extends T> records, long total, int size, int current, int pages) {
        return null;
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
}