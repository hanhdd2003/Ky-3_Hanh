/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithm;

public class TaxiFareCalculator {

    public static double tinhTienTaxi(double soKm) {
        final int CUOC_MO_CUA = 9000; // VND
        final int KM_DAU_TIEN = 30; // km
        final int GIA_DAU_TIEN = 11000; // VND/km
        final int GIA_TU_KM_31 = 9500; // VND/km

        double tienTaxi = 0;
        if (soKm < 0) {
            throw new IllegalArgumentException("So km phai lon hon 0");
        } else if (soKm <= KM_DAU_TIEN) {
            // Nếu số km <= 30
            tienTaxi = CUOC_MO_CUA + soKm * GIA_DAU_TIEN;
        } else {
            // Nếu số km > 30
            tienTaxi = CUOC_MO_CUA + KM_DAU_TIEN * 
                    GIA_DAU_TIEN + (soKm - KM_DAU_TIEN) * GIA_TU_KM_31;
        }
        return tienTaxi;
    }
}
