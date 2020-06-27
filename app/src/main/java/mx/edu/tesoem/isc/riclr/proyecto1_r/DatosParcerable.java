package mx.edu.tesoem.isc.riclr.proyecto1_r;

import android.os.Parcel;
import android.os.Parcelable;

public class DatosParcerable implements Parcelable {
    String matricula, nombre, correo, promedio;

    public DatosParcerable(String matricula, String nombre, String correo, String promedio) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.correo = correo;
        this.promedio = promedio;
    }

    protected DatosParcerable(Parcel in) {
        matricula = in.readString();
        nombre = in.readString();
        correo = in.readString();
        promedio = in.readString();
    }

    public static final Creator<DatosParcerable> CREATOR = new Creator<DatosParcerable>() {
        @Override
        public DatosParcerable createFromParcel(Parcel in) {
            return new DatosParcerable(in);
        }

        @Override
        public DatosParcerable[] newArray(int size) {
            return new DatosParcerable[size];
        }
    };

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPromedio() {
        return promedio;
    }

    public void setPromedio(String promedio) {
        this.promedio = promedio;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(matricula);
        dest.writeString(nombre);
        dest.writeString(correo);
        dest.writeString(promedio);
    }
}
