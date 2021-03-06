package com.seedsoft.ykt.adpter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.seedsoft.ykt.activity.R;
import com.seedsoft.ykt.bean.VoteBean;
import com.seedsoft.ykt.bitmap.util.ImageFetcher;

public class ComVoteAdapter extends BaseAdapter{
	    
    private Context ctx;
    private ArrayList<VoteBean> list ;     
    
	public ComVoteAdapter(Context ctx,ArrayList<VoteBean> list){
		this.ctx = ctx;
		this.list = list;
	}
	


	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	class holdView{
		ImageView icon;
		TextView titel;
		TextView desp;
		TextView author;
		TextView time;
		String authorStr;
		String iconStr;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub			
		holdView hv = null;
		if(convertView == null || convertView.getTag() == null){
						
			hv = new holdView();
			convertView = LayoutInflater.from(ctx).inflate(R.layout.content_list_item, null);
			hv.titel = (TextView) convertView.findViewById(R.id.content_list_item_titel);
			hv.desp = (TextView) convertView.findViewById(R.id.content_list_item_desp);
			hv.author = (TextView) convertView.findViewById(R.id.author);
			hv.time = (TextView) convertView.findViewById(R.id.time);
			hv.icon = (ImageView) convertView.findViewById(R.id.content_list_item_icon);
			convertView.setTag(hv);
			
		}else{
			hv = (holdView) convertView.getTag();
		}
		VoteBean vb = list.get(position);
		hv.titel.setText(vb.getName());
		hv.authorStr = vb.getAuthor();
		
		hv.desp.setVisibility(View.GONE);
		hv.icon.setVisibility(View.GONE);
		
		if(hv.authorStr != null && !hv.authorStr.equals("")){
			hv.author.setText(hv.authorStr);
		}else{
			hv.author.setText("一卡通公司");
		}
		hv.time.setText(vb.getStart().subSequence(0, 11)+"至"+vb.getEnd().subSequence(0, 11));
		
		
		return convertView;
	}	

}
