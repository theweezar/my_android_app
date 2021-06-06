package com.example.resp.helpers;

import com.example.resp.entites.CapPhat;
import com.example.resp.entites.NhanVien;
import com.example.resp.entites.PhongBan;
import com.example.resp.entites.VanPhongPham;

import org.json.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JSONHelper {

    /**
     * Kiểm tra xem response có lỗi hay không
     * @param json - json string được gửi về từ server
     * @return - PASS hoặc là error message
     */
    public String verifyJSON(String json) {
        try {
            JSONObject jsonObj = new JSONObject(json);
            if (jsonObj.has("error")) {
                return jsonObj.getString("message");
            }
        }
        catch (JSONException error) {
            return error.getMessage();
        }
        return "PASS";
    }

    /**
     * parse cái string json lại theo các entities
     * @param json - json string được gửi về từ server
     * @param objectName - tên của các entity
     * @return Object entities
     * @throws JSONException
     */
    public List<Object> parseJSON(String json, String objectName) throws JSONException {
        JSONObject jsonObj = new JSONObject(json);
        JSONArray viewData = jsonObj.getJSONArray("viewData");
        System.out.println(json);

        List<Object> entitiesList = new ArrayList<>();

        if (objectName.trim().equals("PhongBan")) {
            for(int i = 0; i < viewData.length(); i++) {
                PhongBan phongBan = new PhongBan(viewData.getJSONObject(i).getString("MAPB"),
                        viewData.getJSONObject(i).getString("TENPB"));
                entitiesList.add(phongBan);
            }
        }

        if (objectName.trim().equals("NhanVien")) {
            for(int i = 0; i < viewData.length(); i++) {
                NhanVien nhanVien = new NhanVien(
                        viewData.getJSONObject(i).getString("MANV"),
                        viewData.getJSONObject(i).getString("HOTEN"),
                        viewData.getJSONObject(i).getString("NGAYSINH"),
                        viewData.getJSONObject(i).getString("MAPB")
                );
                entitiesList.add(nhanVien);
            }
        }

        if (objectName.trim().equals("VanPhongPham")) {
            for(int i = 0; i < viewData.length(); i++) {
                VanPhongPham vanPhongPham = new VanPhongPham(
                        viewData.getJSONObject(i).getString("MAVPP"),
                        viewData.getJSONObject(i).getString("TENVPP"),
                        viewData.getJSONObject(i).getString("DVT"),
                        viewData.getJSONObject(i).getString("GIANHAP"),
                        viewData.getJSONObject(i).get("HINH").toString(),
                        viewData.getJSONObject(i).getInt("SOLUONG"),
                        viewData.getJSONObject(i).getString("MANCC")
                );
                entitiesList.add(vanPhongPham);
            }
        }

        if (objectName.trim().equals("CapPhat")) {
            for(int i = 0; i < viewData.length(); i++) {
                CapPhat capPhat = new CapPhat(
                        viewData.getJSONObject(i).getString("SOPHIEU"),
                        viewData.getJSONObject(i).getString("NGAYCAP"),
                        viewData.getJSONObject(i).getString("MAVPP"),
                        viewData.getJSONObject(i).getString("MANV"),
                        (long)viewData.getJSONObject(i).getInt("SOLUONG")
                );
                entitiesList.add(capPhat);
            }
        }

        if (objectName.trim().equals("NhaCungCap")) {

        }

        if (objectName.trim().equals("PhieuCungCap")) {

        }

        return entitiesList;
    }

    /**
     * Phương thức dùng để parse tự động tất cả phần tử trong mảng viewData
     * @param json - json string được gửi về từ server
     * @return - 1 cái string chứa tất cả dữ liệu trong đó, nhưng để chỉ show ra để test kết quả
     */
    public String rawParseJSON(String json) {
        String parse = "";

        try {
            // Khởi tạo json object
            JSONObject jsonObj = new JSONObject(json);
            // Trích xuất array viewData để lấy dữ liệu
            JSONArray viewData = jsonObj.getJSONArray("viewData");
            for(int i = 0; i < viewData.length(); i++) {
                JSONObject jsonData = viewData.getJSONObject(i);
                // Iterator khóa trong từng phần tử json object của viewData
                Iterator<String> keys = jsonData.keys();
                while (keys.hasNext()) {
                    String key = keys.next();
                    Object data = jsonData.get(key);
                    if (data != null) parse += String.format("%s\n", data.toString());
                }
            }
        }
        catch (JSONException error) {
            parse = error.getMessage();
        }

        return parse;
    }

    /**
     * Phương thức dùng để parse các hàm thống kê, báo cáo
     * @param json - json string được gửi về từ server
     * @return - ArrayList chứa toàn bộ dữ liệu trong đó
     */
    public List<String> parseJSON(String json) {
        return new ArrayList<>();
    }

    public void printPhongBanEntity(List<Object> phongBanList) {
        for(Object obj: phongBanList) {
            PhongBan pb = (PhongBan)obj;
            System.out.println(pb.getTenpb());
        }
    }
}
