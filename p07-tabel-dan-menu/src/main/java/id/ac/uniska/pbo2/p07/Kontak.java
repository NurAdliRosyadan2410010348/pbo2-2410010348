/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.uniska.pbo2.p07;

/**
 *
 * @author Adli
 */
/**
* Data satu kontak. Record dipakai karena data kontak tidak diubah langsung;
* perubahan dilakukan dengan mengganti object lama dengan object baru.
*/
public record Kontak(String nama, String telepon, String email, Kategori kategori) {
}

