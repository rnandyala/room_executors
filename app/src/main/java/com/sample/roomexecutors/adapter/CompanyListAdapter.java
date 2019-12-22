package com.sample.roomexecutors.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sample.roomexecutors.R;
import com.sample.roomexecutors.data.Company;

import java.util.List;

public class CompanyListAdapter extends RecyclerView.Adapter {

    private List<Company> mListOfCompanies;

    public CompanyListAdapter(List<Company> mListOfCompanies) {

        this.mListOfCompanies = mListOfCompanies;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.company_view_holder, parent, false);


        CompanyViewHolder mCompanyViewHolder = new CompanyViewHolder(v);
        return mCompanyViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TextView mTextView = holder.itemView.findViewById(R.id.companyName);
        mTextView.setText(mListOfCompanies.get(position).getMWord());
    }

    @Override
    public int getItemCount() {
        if (mListOfCompanies != null)
            return mListOfCompanies.size();
        else
            return 0;
    }

    public void setCompanyList(List<Company> mListOfCompanies) {
        this.mListOfCompanies = mListOfCompanies;
        notifyDataSetChanged();
    }


    class CompanyViewHolder extends RecyclerView.ViewHolder {
        public CompanyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(
                    v -> {

                        Toast.makeText(itemView.getContext(), "click_worked", Toast.LENGTH_SHORT).show();
                    }

            );
        }
    }

}
