package com.example.resp.requests;

import com.example.resp.WebService;
import com.example.resp.entites.ChiTietCungCap;
import com.example.resp.entites.PhieuCungCap;
import com.example.resp.helpers.RequestHelper;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;

public class PhieuCungCapRequest {

    public String doGet(String method) {
        RequestHelper requestHelper = new RequestHelper();
        String[] request = {"get", String.format("http://%s/PhieuCungCapController-%s", WebService.host(), method)};
        String response = "";
        try {
            response = requestHelper.execute(request).get();
        }
        catch(ExecutionException e){
            response = e.getMessage();
        }
        catch(InterruptedException e){
            response = e.getMessage();
        }
        return response;
    }

    public String doPost(PhieuCungCap phieuCungCap,
                         ChiTietCungCap chiTietCungCap,
                         String method) {
        RequestHelper requestHelper = new RequestHelper();
        // Tạo HashMap để tạo requestBody
        HashMap<String, String> hashMap = new HashMap<>();

        if (phieuCungCap != null) {
            hashMap.put("sophieu", phieuCungCap.getSoPhieu());
            hashMap.put("trangthai", phieuCungCap.getTrangThai());
            hashMap.put("mancc", phieuCungCap.getMaNcc());
        }
        else if (chiTietCungCap != null) {
            hashMap.put("sophieu", chiTietCungCap.getSoPhieu());
            hashMap.put("mavpp", chiTietCungCap.getMaVpp());
            hashMap.put("soluong", chiTietCungCap.getSoLuong());
            hashMap.put("thanhtien", chiTietCungCap.getThanhTien());
        }

        // Bắt đầu thực hiện request
        requestHelper.buildRequestBody(hashMap);
        String[] request = {"post", String.format("http://%s/PhieuCungCapController-%s",
                WebService.host(), method)};
        String response = "";
        try {
            response = requestHelper.execute(request).get();
        }
        catch(ExecutionException e){
            response = e.getMessage();
        }
        catch(InterruptedException e){
            response = e.getMessage();
        }
        return response;
    }
}
