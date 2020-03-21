package Adapters;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Forecast;
import com.example.myapplication.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    private List<Forecast> dataModelList;

    public RecyclerViewAdapter (List<Forecast> dataModelList) { this.dataModelList = dataModelList;}

    @NonNull
    @Override
    public  RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerViewHolder viewHolder;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_list, parent,false);
        viewHolder = new RecyclerViewHolder(view);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position){
        //holder.tvDate.setTypeface(null, Typeface.BOLD);
        holder.tvDate.setText(Html.fromHtml("Date : " + String.valueOf(dataModelList.get(position).formatDate())));
        holder.tvTemp.setText(Html.fromHtml(String.valueOf(Integer.toString(Math.round(dataModelList.get(position).getMain().getTemp())) + "°C</b>")));

        switch (dataModelList.get(position).getWeather().get(0).getMain()) {
            case "Rain":
                holder.cloud.setImageResource(R.drawable.pluie);
                break;

            case "Clouds":
                holder.cloud.setImageResource(R.drawable.unnamed);
                break;

            case "Thunderstorm":
                holder.cloud.setImageResource(R.drawable.eclair);
                break;

            case "Drizzle":
                holder.cloud.setImageResource(R.drawable.bruine);
                break;

            case "Snow":
                holder.cloud.setImageResource(R.drawable.neige);
                break;

            default:
                holder.cloud.setImageResource(R.drawable.cielbleu);
        }
    }

    public long getItemId(int position){
        return super.getItemId(position);
    }

    @Override
    public int getItemCount(){
        return  dataModelList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        ImageView cloud;
        TextView tvDate;
        TextView tvTemp;
        RelativeLayout LLItemView;

        public RecyclerViewHolder(@NonNull View itemView){
            super(itemView);
            LLItemView = itemView.findViewById(R.id.LLItemView);
            cloud = itemView.findViewById(R.id.cloud);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvTemp = itemView.findViewById(R.id.tvTemp);
        }
    }
}
