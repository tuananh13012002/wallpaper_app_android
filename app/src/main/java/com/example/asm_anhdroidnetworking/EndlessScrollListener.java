package com.example.asm_anhdroidnetworking;

import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import org.jetbrains.annotations.NotNull;

public abstract class EndlessScrollListener extends RecyclerView.OnScrollListener {
    /// Số lượng mục tối thiểu phải có bên dưới vị trí cuộn hiện tại của bạn
    // trước khi tải thêm.
    private int visibleThreshold = 5;
    // Chỉ mục bù đắp hiện tại của dữ liệu bạn đã tải
    private int currentPage = 0;
    // Tổng số mục trong tập dữ liệu sau lần tải cuối cùng
    private int previousTotalItemCount = 0;
    // Đúng nếu chúng ta vẫn đang đợi tải tập dữ liệu cuối cùng.
    private boolean loading = true;
    // Đặt chỉ mục trang bắt đầu
    private int startingPageIndex = 0;
    RecyclerView.LayoutManager layoutManager;

    public EndlessScrollListener(LinearLayoutManager layoutManager) {
        this.layoutManager = layoutManager;
    }

    public EndlessScrollListener(GridLayoutManager layoutManager) {
        this.layoutManager = layoutManager;
        visibleThreshold = visibleThreshold*layoutManager.getSpanCount();
    }
    public EndlessScrollListener(StaggeredGridLayoutManager layoutManager) {
        this.layoutManager = layoutManager;
        visibleThreshold = visibleThreshold*layoutManager.getSpanCount();
    }
    public int getLastVisibleItem(int [] lastVisibleItemPositions){
        int maxSize=0;
        for (int i=0;i<lastVisibleItemPositions.length;i++){
            if(i==0){
                maxSize=lastVisibleItemPositions[i];
            }else if(lastVisibleItemPositions[i]>maxSize){
                maxSize=lastVisibleItemPositions[i];
            }
        }
        return maxSize;
    }

    @Override
    public void onScrolled(@NonNull @NotNull RecyclerView recyclerView, int dx, int dy) {
        int lastVisibleItemPosition = 0;
        int totalItemCount = layoutManager.getItemCount();
        if(layoutManager instanceof StaggeredGridLayoutManager){
            int[] lastVisibleItemPositions=((StaggeredGridLayoutManager) layoutManager).findLastVisibleItemPositions(null);
            lastVisibleItemPosition=getLastVisibleItem(lastVisibleItemPositions);
        }else if(layoutManager instanceof GridLayoutManager){
            lastVisibleItemPosition=((GridLayoutManager) layoutManager).findLastVisibleItemPosition();
        }else if(layoutManager instanceof LinearLayoutManager){
            lastVisibleItemPosition=((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
        }

        if(totalItemCount<previousTotalItemCount){
            this.currentPage=this.startingPageIndex;
            this.previousTotalItemCount=totalItemCount;
            if(totalItemCount==0){
                this.loading=true;
            }
        }

        if(loading&&(totalItemCount>previousTotalItemCount)){
            loading=false;
            previousTotalItemCount=totalItemCount;
        }

        if(!loading&&(lastVisibleItemPosition+visibleThreshold)>totalItemCount){
            currentPage++;
            onLoadMore(currentPage,totalItemCount,recyclerView);
            loading=true;
        }
    }
    public void resetState(){
        this.currentPage=this.startingPageIndex;
        this.previousTotalItemCount=0;
        this.loading=true;
    }

    public abstract void onLoadMore(int page, int totalItemsCount, RecyclerView view);
}
