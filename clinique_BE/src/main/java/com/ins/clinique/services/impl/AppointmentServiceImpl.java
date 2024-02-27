package com.ins.clinique.services.impl;

import com.ins.clinique.entities.*;
import com.ins.clinique.entities.dtos.*;
import com.ins.clinique.entities.mappers.*;
import com.ins.clinique.repositories.*;
import com.ins.clinique.services.AppointmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    private AppointmentRepository appointmentRepository;
    private EntrepriseRepository entrepriseRepository;
    private AppointmentMapper appointmentMapper;
    private DoctorRepository doctorRepository;
    private PatientRepository patientRepository;
    private MedicalActRepository medicalActRepository;
    private TechnicienRepository technicienRepository;
    private DoctorMapper doctorMapper;
    private TechnicienMapper technicienMapper;
    private PatientMapper patientMapper;
    private MedicalActMapper medicalActMapper;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, AppointmentMapper appointmentMapper, EntrepriseMapper entrepriseMapper, EntrepriseRepository entrepriseRepository, DoctorRepository doctorRepository, PatientRepository patientRepository, MedicalActRepository medicalActRepository, TechnicienRepository technicienRepository, DoctorMapper doctorMapper, TechnicienMapper technicienMapper, PatientMapper patientMapper, MedicalActMapper medicalActMapper) {
        this.appointmentRepository = appointmentRepository;
        this.appointmentMapper = appointmentMapper;
        this.entrepriseRepository = entrepriseRepository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
        this.medicalActRepository = medicalActRepository;
        this.technicienRepository = technicienRepository;
        this.doctorMapper = doctorMapper;
        this.technicienMapper = technicienMapper;
        this.patientMapper = patientMapper;
        this.medicalActMapper = medicalActMapper;
    }
    AppointmentDto toDto(Appointment appointment){
        return appointmentMapper.toDto(appointment);
    }
    Appointment fromDto(AppointmentDto dto){

        return appointmentMapper.fromDto(dto);
    }
    Appointment insertfromDto(InsertAppointmentDto dto){

        return appointmentMapper.fromDtoInsert(dto);
    }
    DoctorDto fromDtoDoctor(Doctor d){
        return doctorMapper.fromEntity(d);
    }
    PatientDto fromDtoPatient(Patient d){
        return patientMapper.toDto(d);
    }
    MedicalActDto fromDtoMedicalAct(MedicalAct d){
        return medicalActMapper.toDto(d);
    }
    TechnicienDto fromDtoTechnicien(Technicien d){
        return technicienMapper.toDto(d);
    }
    @Override
    public List<AppointmentDto> getAllAppointments() {
        return appointmentRepository.findAll()
                .stream()
                .map(
                        this::toDto
                )
                .toList();
    }

    @Override
    public AppointmentDto getAppointmentByID(int id) {
        return toDto(appointmentRepository.findById( id).get());
    }


    @Override
    public AppointmentDto updateAppointment(int id, AppointmentDto dto) {
        if(! appointmentRepository.existsById(id)){
            return null;
        }
        return toDto(appointmentRepository.save(fromDto(dto)));
    }

    @Override
    public void saveAppointment(InsertAppointmentDto dto) {
        if (entrepriseRepository.findById(dto.getEntrepriseId())==null){

        }else{
            DoctorDto saveDoctor = fromDtoDoctor(doctorRepository.findById(dto.getDoctorDto()).get());
//            PatientDto savePatient = fromDtoPatient(patientRepository.findById(dto.getPatientID()).get());
//            TechnicienDto saveTechnicien= fromDtoTechnicien(technicienRepository.findById(dto.getTechnicienID()).get());
//            MedicalActDto saveMedicalActDto = fromDtoMedicalAct(medicalActRepository.findById(dto.getMedicalActID()).get());
            AppointmentDto saveAppointmentDto = new AppointmentDto();
            BeanUtils.copyProperties(dto,saveAppointmentDto);
            saveAppointmentDto.setDoctorDto(saveDoctor);
//            saveAppointmentDto.setPatientDto(savePatient);
//            saveAppointmentDto.setTechnicienDto(saveTechnicien);
//            saveAppointmentDto.setMedicalActDto(saveMedicalActDto);
            appointmentRepository.save(fromDto(saveAppointmentDto));
        }

    }
}
