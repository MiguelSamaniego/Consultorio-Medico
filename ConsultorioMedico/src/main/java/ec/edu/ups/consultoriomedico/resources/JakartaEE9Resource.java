package ec.edu.ups.consultoriomedico.resources;

import ec.edu.ups.consultoriomedico.facade.ColaboradorFacade;
import ec.edu.ups.consultoriomedico.facade.ConsultaFacade;
import ec.edu.ups.consultoriomedico.facade.DoctorFacade;
import ec.edu.ups.consultoriomedico.facade.PacienteFacade;
import ec.edu.ups.consultoriomedico.facade.ConsultaFacade;
import ec.edu.ups.consultoriomedico.facade.PrescripcionCabeceraFacade;
import ec.edu.ups.consultoriomedico.facade.PrescripcionDetalleFacade;
import ec.edu.ups.consultoriomedico.modelo.Doctor;
import ec.edu.ups.consultoriomedico.modelo.Paciente;
import ec.edu.ups.consultoriomedico.modelo.Consulta;
import ec.edu.ups.consultoriomedico.modelo.PrescripcionCabecera;
import ec.edu.ups.consultoriomedico.modelo.PrescripcionDetalle;
import jakarta.ejb.EJB;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author
 */
@Path("jakartaee9")
public class JakartaEE9Resource {

    GregorianCalendar fecha = new GregorianCalendar();
    @EJB
    private DoctorFacade ejbDoctorFacade;
    @EJB
    private PacienteFacade ejbPaciente;
    @EJB
    private ColaboradorFacade ejbColaborador;
    @EJB
    private ConsultaFacade ejbConsulta;

    @EJB
    private PrescripcionCabeceraFacade ejbCabecera;
    @EJB
    private PrescripcionDetalleFacade ejbDetalle;

    @GET
    public Response ping() {

        Doctor doctor = new Doctor("General", 1, "Miguel Samaniego", "1400789723", "0986832325", "miguel1@gmail.com", "Adolfo Torres", true, fecha);
        ejbDoctorFacade.create(doctor);
        Paciente paciente = new Paciente(fecha, 0, "Migel Angel", "1400789721", "0984532324", "paciente@gmail.com", "Adolfot Torres", true, fecha);
        ejbPaciente.create(paciente);

        PrescripcionCabecera cabecera = new PrescripcionCabecera(3, "hola");

        ejbCabecera.create(cabecera);
        PrescripcionDetalle detalle = new PrescripcionDetalle(0, "medicina", "cada 8 horas", "por un mes", cabecera);

        PrescripcionDetalle detalle1 = new PrescripcionDetalle(1, "medicina", "cada 8 horas", "por un mes", cabecera);
        ejbDetalle.create(detalle);
        ejbDetalle.create(detalle1);
        Consulta consulta = new Consulta(2, fecha, doctor, paciente, "no hay observaciones", 0, cabecera);
        ejbConsulta.create(consulta);

        return Response
                .ok("ping Jakarta EE")
                .build();
    }
}
