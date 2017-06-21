package main;

public class Person {
	//fomrat; name surname ; phone ; email ; address
	
	//Las variables no se acceden directamente, para eso estan
	//getters y setters
	private String name;
	private String surname;
	private String phone;
	private String email;
	private String address;
	
	@Deprecated
	//ESTO ES EL CONSTRUCTOR:
	public Person(String name, String surname, String phone, String email, String address){
		//Al constructor le pasamos todos los parametros pero es rapido
		//porque es complejo.
		
		//Mas comun es usar getters. Source\Generate Getters and Setters...
		this.name=name;
		this.surname=surname;
		//Mas politicamente correcto:
		setPhone(phone);
		setEmail(email);
		setAddress(address);
	}
	/**
	 * Crea nueva persona con formato:
	 * "name surname;email;phone;address"
	 * @param contactFileFormat
	 */
	//OTRO CONSTRUCTOR (polimorfismo)
	public Person(String contactFileFormat){
		String[] values = contactFileFormat.split(";");
		if(values.length<4)
			throw new RuntimeException("Formato incorrecto en contactFileForm");
		
		String fullName[] = values[0].split(" ");
		
		String nombre = fullName.length==2?fullName [0]:values[0];
		String apellido = fullName.length==2?fullName[1]:"";
			
		setName(nombre);
		setSurname(apellido);
		
		setPhone(values[1]);
		setEmail(values[2]);
		setAddress(values[3]);
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		//this (esta clase) .name
		//Otra opcion:
		//public void (String Aname)
		//name=Aname
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	

	
	@Override
	public String toString(){
		
		//String baseStr = super.toString();
		return "Person: " + name + " " + surname + " " + email + " " + phone + " " + address;
		
	}
	
	@Override
	public boolean equals(Object obj){
		boolean r=false;
		Person person = (Person) obj;
		
		if(this.name.equals(person.getName())&& //person.name tb funcionaria pq estamos dentro clase
				this.surname.equals(person.getSurname()) &&
					this.phone.equals(person.getPhone()) &&
							this.email.equals(person.getEmail())&&
								this.address.equals(person.getAddress())){ 
			r=true;
		}
		return r;
	}
	
	public String getFullName(){
		return getName() + " " + getSurname();
	}
	
	public static String getNameFromFullName(String strfullName){
		String fullName[]=strfullName.split(" ");
		return fullName[0];
	}
	
	public static String getSurnameFromFullName(String strfullName){
		String fullName[]=strfullName.split(" ");
		return fullName.length==2?fullName [1]:"";
	}
	public String toFileFormat(){
		if (surname==""){
			return name  + ";" + email + ";" + phone + ";" + address;
		}else{
			return name + ";" + surname + ";" + email + ";" + phone + ";" + address;
		}
		
		
	}
}
