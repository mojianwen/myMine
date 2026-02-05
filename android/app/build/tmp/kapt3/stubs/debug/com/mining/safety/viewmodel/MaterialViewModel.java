package com.mining.safety.viewmodel;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\nJ\u000e\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u0019J\u000e\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\nR\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0019\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\fX\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/mining/safety/viewmodel/MaterialViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_error", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_loading", "", "_materialList", "", "Lcom/mining/safety/model/Material;", "currentPage", "", "error", "Lkotlinx/coroutines/flow/StateFlow;", "getError", "()Lkotlinx/coroutines/flow/StateFlow;", "loading", "getLoading", "materialList", "getMaterialList", "materialRepository", "Lcom/mining/safety/repository/MaterialRepository;", "pageSize", "addMaterial", "", "material", "deleteMaterial", "id", "", "loadMaterialList", "updateMaterial", "app_debug"})
public final class MaterialViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.mining.safety.repository.MaterialRepository materialRepository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.mining.safety.model.Material>> _materialList = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.mining.safety.model.Material>> materialList = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _loading = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> loading = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _error = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> error = null;
    private int currentPage = 1;
    private final int pageSize = 10;
    
    public MaterialViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.mining.safety.model.Material>> getMaterialList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getError() {
        return null;
    }
    
    public final void loadMaterialList() {
    }
    
    public final void addMaterial(@org.jetbrains.annotations.NotNull
    com.mining.safety.model.Material material) {
    }
    
    public final void updateMaterial(@org.jetbrains.annotations.NotNull
    com.mining.safety.model.Material material) {
    }
    
    public final void deleteMaterial(long id) {
    }
}