package com.mining.safety.ui.course;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0010\u0011B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\u001c\u0010\b\u001a\u00020\u00062\n\u0010\t\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/mining/safety/ui/course/CourseAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/mining/safety/model/Course;", "Lcom/mining/safety/ui/course/CourseAdapter$CourseViewHolder;", "onItemClick", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "CourseDiffCallback", "CourseViewHolder", "app_debug"})
public final class CourseAdapter extends androidx.recyclerview.widget.ListAdapter<com.mining.safety.model.Course, com.mining.safety.ui.course.CourseAdapter.CourseViewHolder> {
    @org.jetbrains.annotations.NotNull
    private final kotlin.jvm.functions.Function1<com.mining.safety.model.Course, kotlin.Unit> onItemClick = null;
    
    public CourseAdapter(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.mining.safety.model.Course, kotlin.Unit> onItemClick) {
        super(null);
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.mining.safety.ui.course.CourseAdapter.CourseViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.mining.safety.ui.course.CourseAdapter.CourseViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/mining/safety/ui/course/CourseAdapter$CourseDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/mining/safety/model/Course;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_debug"})
    public static final class CourseDiffCallback extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.mining.safety.model.Course> {
        
        public CourseDiffCallback() {
            super();
        }
        
        @java.lang.Override
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull
        com.mining.safety.model.Course oldItem, @org.jetbrains.annotations.NotNull
        com.mining.safety.model.Course newItem) {
            return false;
        }
        
        @java.lang.Override
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull
        com.mining.safety.model.Course oldItem, @org.jetbrains.annotations.NotNull
        com.mining.safety.model.Course newItem) {
            return false;
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/mining/safety/ui/course/CourseAdapter$CourseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/mining/safety/databinding/ItemCourseBinding;", "(Lcom/mining/safety/ui/course/CourseAdapter;Lcom/mining/safety/databinding/ItemCourseBinding;)V", "bind", "", "course", "Lcom/mining/safety/model/Course;", "app_debug"})
    public final class CourseViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final com.mining.safety.databinding.ItemCourseBinding binding = null;
        
        public CourseViewHolder(@org.jetbrains.annotations.NotNull
        com.mining.safety.databinding.ItemCourseBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        com.mining.safety.model.Course course) {
        }
    }
}