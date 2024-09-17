package org.data.dummy.service;

import lombok.*;
import org.data.dummy.Entity.*;
import org.data.dummy.Repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.math.*;
import java.util.*;


@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Microservices {

    Random random = new Random();

    @Autowired
    StudentPersonalDataDao dao;

    String getMaleFirstName() {
        String[] firstNames = {"Aarav", "Abhay", "Abhimanyu", "Aditya", "Ajay", "Akhil", "Aman", "Amit", "Anil", "Anirudh", "Ankit", "Arjun", "Arnav", "Ashish", "Atul", "Avinash", "Bharat", "Bhavesh", "Chandan", "Chirag", "Chetan", "Darshan", "Deepak", "Dev", "Dhruv", "Dinesh", "Dushyant", "Eshan", "Gaurav", "Girish", "Gopal", "Govind", "Harish", "Harsh", "Hemant", "Himanshu", "Inder", "Ishaan", "Jai", "Jatin", "Jayesh", "Jeet", "Jitendra", "Kailash", "Kamal", "Karan", "Kartik", "Kiran", "Krishna", "Kuldeep", "Lakshman", "Lalit", "Lokesh", "Madhav", "Mahesh", "Manish", "Mohan", "Mukesh", "Naveen", "Nikhil", "Nilesh", "Niraj", "Omkar", "Pankaj", "Parag", "Parth", "Pradeep", "Prakash", "Pranav", "Prashant", "Raghav", "Rahul", "Raj", "Rakesh", "Raman", "Ramesh", "Ravi", "Rishi", "Rohit", "Sachin", "Sagar", "Sandeep", "Sanjay", "Santosh", "Sarvesh", "Satish", "Saurabh", "Shankar", "Shashank", "Shiv", "Siddharth", "Somesh", "Sudhir", "Suman", "Sunil", "Suraj", "Suresh", "Tarun", "Uday", "Umesh", "Varun", "Vijay", "Vikas", "Vikram", "Vishal", "Yash", "Abhishek", "Akhilesh", "Alok", "Aman", "Amrit", "Anand", "Anuj", "Arvind", "Ashok", "Avi", "Balaji", "Bhanu", "Bipin", "Chand", "Daya", "Dheeraj", "Divyansh", "Durgesh", "Ganesh", "Harinder", "Hemendra", "Indra", "Jagdish", "Jay", "Kaushal", "Keshav", "Laxman", "Mahavir", "Manoj", "Milan", "Mohanlal", "Mukund", "Nand", "Narendra", "Naresh", "Naveen", "Neeraj", "Om", "Palash", "Prabhakar", "Pranjal", "Rajesh", "Ram", "Rohin", "Samir", "Sanjeev", "Shivam", "Shrikant", "Shyam", "Som", "Srikant", "Subhash", "Sukhdev", "Tej", "Tushar", "Uttam", "Vasu", "Ved", "Vipul", "Vishnu", "Yuvraj", "Abhinav", "Adarsh", "Ajit", "Alok", "Amar", "Amitabh", "Anant", "Ankur", "Arif", "Ashwin", "Balram", "Bharat", "Chetanya", "Daksh", "Darshan", "Deva", "Dharam", "Eklavya", "Gaurang", "Gaurish", "Harsha", "Harshal", "Ishwar", "Jagdish", "Jagjit", "Kailas", "Keshar", "Lakhan", "Madhukar", "Mahinder", "Manav", "Mohinder", "Murli", "Navin", "Nilesh", "Omprakash", "Pallav", "Prabhu", "Prashant", "Prathamesh", "Pushkar", "Rahman", "Rajendra", "Ramchandra", "Ranveer", "Rishi", "Roshan", "Sanjit", "Saroj", "Shailesh", "Soham", "Sudhakar", "Sunandan", "Tanmay", "Tilak", "Upendra", "Vibhav", "Vikas", "Vinod", "Yatin", "Abhijeet", "Advaith", "Ahsan", "Akash", "Amitesh", "Animesh", "Anurag", "Ashutosh", "Bhargav", "Binod", "Chaitanya", "Deenbandhu", "Devang", "Devendra", "Dipak", "Girish", "Gopesh", "Harman", "Indrajeet", "Jeevan", "Kartikeya", "Kedar", "Kiran", "Kunal", "Luv", "Madhukar", "Mansukh", "Naitik", "Nishant", "Nityanand", "Paritosh", "Praveen", "Raghunath", "Rajiv", "Ramanuj", "Ratan", "Sachidanand", "Samarth", "Shubham", "Sumit", "Surinder", "Tanveer", "Tapan", "Trilok", "Vibhuti", "Vimal", "Vinay", "Vinit", "Yogesh", "Aaditya", "Abdullah", "Ajitesh", "Akshay", "Amogh", "Ashwani", "Bhavin", "Chirayu", "Debashish", "Gurpreet", "Harpreet", "Jaskaran", "Kaivalya", "Kirtan", "Lalitkumar", "Lalitendu", "Madhavendra", "Maitreya", "Mayank", "Namit", "Parmanand", "Pratap", "Prem", "Ranjan", "Raviendra", "Sandeepan", "Santanu", "Shaan", "Shaurya", "Sumeet", "Sushil", "Tribhuwan", "Udbhav", "Umang", "Vallabh", "Vikrant", "Vinayak", "Vivek", "Yatindra", "Advik", "Bhuvan", "Cyrus", "Dhananjay", "Eshwar", "Farhan", "Gajanan", "Hitesh", "Jayant", "Keshava", "Laxmikant", "Mahindra", "Naveen", "Padmanabhan", "Parimal", "Rajneesh", "Rajveer", "Saket", "Satvinder", "Sharad", "Sumit", "Supratim", "Tridib", "Varad", "Vijendra", "Viraj", "Vishwajeet", "Yadunath", "Yuvraj", "Zakir", "Anil", "Nitin", "Vaibhav", "Ashraf", "Shaheen", "Wasi", "Qasim", "Satyendra", "Zaid", "Firoz", "Rafiq", "Khaleel", "Nasir", "Saleem", "Sadiq", "Tauheed", "Zubair", "Nazir", "Waseem", "Farooq", "Majid", "Tanveer", "Hamid", "Hafiz", "Waris", "Sharif", "Basheer", "Nawaz", "Fahim", "Javed", "Tariq", "Asif", "Imran", "Mehboob", "Parvez", "Irfan", "Shahid", "Zulfiqar", "Hameed", "Salman", "Shoaib", "Abrar", "Touqeer", "Nadeem"};
        int randomIndex = random.nextInt(firstNames.length);
        return firstNames[randomIndex];
    }


    String getFemaleFirstName() {
        String[] femaleFirstNames = {"Aadhira", "Aadya", "Aahana", "Aalia", "Aamani", "Aanya", "Aaradhya", "Aarti", "Aashi", "Aastha", "Aayushi", "Abha", "Abhilasha", "Aditi", "Advika", "Ahana", "Aishani", "Aishwarya", "Akanksha", "Akriti", "Alia", "Amara", "Ambika", "Amisha", "Amrita", "Ananya", "Anika", "Anisha", "Anjali", "Ankita", "Anmol", "Annapurna", "Anshika", "Antara", "Anusha", "Anvi", "Aparna", "Aradhana", "Arpita", "Arshia", "Asha", "Ashwini", "Asmita", "Astha", "Atreyi", "Avani", "Avika", "Ayushi", "Babita", "Barkha", "Bhagyashree", "Bhairavi", "Bhavana", "Bhoomika", "Bina", "Bindu", "Charu", "Chavi", "Chandni", "Chitra", "Damini", "Darika", "Deepa", "Deepika", "Deepti", "Devika", "Dhara", "Diksha", "Dipti", "Divya", "Dolly", "Draupadi", "Durga", "Eesha", "Eshita", "Ekta", "Elina", "Esha", "Farah", "Falguni", "Gargi", "Garima", "Gayatri", "Geeta", "Geetanjali", "Gauri", "Gayathri", "Hansa", "Harini", "Harsha", "Heena", "Hema", "Hemlata", "Hetal", "Himani", "Ila", "Indira", "Indu", "Ira", "Isha", "Ishita", "Iti", "Jahnavi", "Jagruti", "Jai", "Jasmine", "Jayanti", "Jaya", "Jyoti", "Janki", "Kajal", "Kalyani", "Kamini", "Kamya", "Kanchan", "Kanika", "Kanta", "Kavita", "Kavya", "Keerti", "Khushboo", "Kirti", "Krishna", "Kritika", "Kshama", "Kumari", "Lakshmi", "Lata", "Lavanya", "Leela", "Lekha", "Lina", "Lipika", "Lisha", "Lopa", "Madhavi", "Madhu", "Madhuri", "Mahi", "Mahima", "Malavika", "Mala", "Malini", "Manisha", "Mansi", "Manju", "Maya", "Meera", "Meghana", "Mehek", "Minal", "Mira", "Mitali", "Mona", "Monika", "Mounika", "Mugdha", "Mukta", "Namita", "Naina", "Nandini", "Neela", "Neelam", "Neha", "Nikita", "Nila", "Nimisha", "Nisha", "Nishtha", "Niti", "Nitya", "Nivedita", "Noor", "Nupur", "Pallavi", "Pankhuri", "Pari", "Parina", "Parul", "Pavani", "Payal", "Pia", "Poonam", "Pragati", "Prachi", "Pranavi", "Pranjal", "Pratibha", "Preeti", "Preksha", "Priya", "Priyanka", "Puja", "Purnima", "Radha", "Radhika", "Ragini", "Rajni", "Raksha", "Ramya", "Rashi", "Ratna", "Reema", "Reena", "Rekha", "Reshma", "Riddhi", "Ritika", "Riya", "Roshni", "Rubina", "Ruchi", "Rupali", "Saanvi", "Sadhana", "Sakshi", "Saloni", "Sama", "Sameera", "Samiksha", "Sana", "Sandhya", "Sangeeta", "Sanjana", "Sapna", "Sara", "Sarika", "Sarla", "Saroj", "Sarvani", "Savita", "Seema", "Shalini", "Shama", "Shanaya", "Sharada", "Sharmila", "Sheela", "Sheetal", "Shefali", "Shikha", "Shilpa", "Shivani", "Shraddha", "Shreya", "Shrishti", "Shruti", "Shubha", "Shweta", "Simran", "Smita", "Sneha", "Sonali", "Soni", "Sonika", "Sowmya", "Srishti", "Suchitra", "Sudha", "Sujata", "Suman", "Sumitra", "Sunaina", "Sunita", "Surbhi", "Suruchi", "Sushma", "Swara", "Swati", "Sweta", "Tanisha", "Tanuja", "Tara", "Tarika", "Tejaswini", "Trisha", "Tulika", "Udaya", "Uma", "Urvashi", "Vaidehi", "Vaishali", "Vani", "Varsha", "Vasudha", "Vatsala", "Vedika", "Veena", "Vibha", "Vidya", "Vijaya", "Vinita", "Vishakha", "Yamini", "Yashasvi", "Yogita", "Yukta", "Zara", "Zeenat", "Zoya", "Aafreen", "Aanchal", "Aarohi", "Aashika", "Abhilasha", "Adhira", "Aditi", "Ahalya", "Alka", "Amala", "Amita", "Anamika", "Anchal", "Anisha", "Ankita", "Anuja", "Anupama", "Aruna", "Arushi", "Ashna", "Asin", "Asmita", "Avani", "Ayisha", "Bela", "Bhanu", "Bhavika", "Brinda", "Bhuvana", "Chaitali", "Charvi", "Damini", "Deepali", "Devaki", "Dhanashree", "Divyani", "Drishti", "Ekta", "Geeta", "Grishma", "Gunjan", "Harshita", "Heeral", "Hetal", "Ipsita", "Ishika", "Jasleen", "Jaya", "Jinal", "Jiya", "Kalpana", "Kalyani", "Kamala", "Kanika", "Karishma", "Kashish", "Ketaki", "Komal", "Kripa", "Kshipra", "Lalita", "Lata", "Lavina", "Madhura", "Mahima", "Maitreyee", "Malini", "Mamta", "Manini", "Medha", "Meghana", "Meghna", "Minakshi", "Mridula", "Neeta", "Nidhi", "Niharika", "Nilima", "Nimrat", "Ojaswini", "Padma", "Pavitra", "Pratima", "Priti", "Priyal", "Prisha", "Radha", "Ragini", "Rajeshwari", "Rekha", "Renuka", "Riddhima", "Ritu", "Roshni", "Saheli", "Saumya", "Savera", "Savitri", "Sejal", "Shaila", "Siddhi", "Srishti", "Sujata", "Supriya", "Sushila", "Tanu", "Tanushree", "Tanya", "Tisya", "Tripti", "Ujwala", "Valli", "Vaishnavi", "Varalakshmi", "Varuna", "Vedanti", "Vidushi", "Vineeta", "Yamini", "Yashika", "Yutika", "Zaina", "Zainab", "Zara"};

        int randomIndex = random.nextInt(femaleFirstNames.length);
        return femaleFirstNames[randomIndex];
    }

    String getFemaleLastName() {
        String[] femaleLastNames = {"Agarwal", "Ahuja", "Ajmera", "Alva", "Ambani", "Anand", "Arora", "Bajpai", "Bansal", "Bhat", "Bhattacharya", "Chakraborty", "Chakra", "Chauhan", "Chopra", "Dey", "Desai", "Deshmukh", "Dey", "Dutta", "Ghosh", "Gokhale", "Gupta", "Hegde", "Jain", "Jha", "Joshi", "Jain", "Kapoor", "Kaur", "Khan", "Kohli", "Kumar", "Kumar", "Madhavan", "Mahajan", "Malhotra", "Mehta", "Menon", "Mitra", "Mishra", "Mittal", "Mohan", "Nair", "Naidu", "Nanda", "Nath", "Nayak", "Patel", "Pillai", "Rai", "Raj", "Rana", "Rao", "Rawat", "Reddy", "Saha", "Sahu", "Saini", "Sanghvi", "Sarkar", "Sethi", "Sharma", "Singh", "Sinha", "Soni", "Srinivasan", "Sundaram", "Swamy", "Tandon", "Thakur", "Tripathi", "Verma", "Vijay", "Vyas", "Yadav", "Agarwal", "Anand", "Bhargava", "Chandra", "Choudhury", "Deshpande", "Dewan", "Dubey", "Garg", "Ghosal", "Gupta", "Haldar", "Iyer", "Jain", "Kapoor", "Kashyap", "Khatri", "Kumar", "Kushwaha", "Lal", "Lalwani", "Madan", "Madhur", "Maheshwari", "Mandke", "Mathur", "Mehra", "Mittal", "Nagpal", "Nath", "Nayar", "Pachauri", "Pandey", "Parikh", "Patil", "Purohit", "Rajput", "Rathi", "Rathi", "Reddy", "Sahasranaman", "Saini", "Sanghvi", "Sarkar", "Sarma", "Sethi", "Shah", "Sharma", "Singh", "Soni", "Srinivasan", "Sundaram", "Tiwari", "Varma", "Vijay", "Vora", "Yadav", "Agarwal", "Ahuja", "Bhattacharya", "Bora", "Chakraborty", "Choudhury", "Das", "Deb", "Deshmukh", "Garg", "Ghosh", "Gupta", "Hegde", "Iyer", "Jain", "Joshi", "Kapoor", "Khatri", "Kumar", "Lal", "Lalwani", "Mahajan", "Mehta", "Mittal", "Nair", "Nayak", "Patel", "Pillai", "Rai", "Raj", "Rao", "Rawat", "Reddy", "Saha", "Sahu", "Saini", "Sarkar", "Sharma", "Singh", "Srinivasan", "Tandon", "Thakur", "Tripathi", "Verma", "Vyas", "Yadav", "Abraham", "Agarwal", "Ahluwalia", "Ahuja", "Anand", "Bansal", "Bhat", "Bhattacharya", "Chakraborty", "Chauhan", "Chopra", "Das", "Desai", "Deshmukh", "Dey", "Dutta", "Ghosh", "Gupta", "Jain", "Kapoor", "Kaur", "Khan", "Kohli", "Kumar", "Lal", "Malhotra", "Mehta", "Mitra", "Mishra", "Mittal", "Naidu", "Nair", "Nayak", "Patel", "Pillai", "Rai", "Raj", "Rana", "Rao", "Rawat", "Reddy", "Saha", "Sahu", "Saini", "Sanghvi", "Sarkar", "Sethi", "Sharma", "Singh", "Soni", "Srinivasan", "Sundaram", "Tandon", "Thakur", "Tripathi", "Verma", "Vora", "Yadav"};

        int randomIndex = random.nextInt(femaleLastNames.length);
        return femaleLastNames[randomIndex];
    }

    String getMaleLastName() {

        String[] lastNames = {"Agarwal", "Agnihotri", "Ahluwalia", "Ahuja", "Ajmera", "Akkiraju", "Ambani", "Amble", "Anand", "Apte", "Arora", "Asthana", "Atwal", "Awasthi", "Bachchan", "Badami", "Bagga", "Bahadur", "Baig", "Bajaj", "Bakshi", "Balachandran", "Balan", "Balasubramanian", "Bali", "Bandyopadhyay", "Banerjee", "Bansal", "Barad", "Barve", "Batra", "Bawa", "Bedi", "Behari", "Behl", "Bendre", "Bhagat", "Bhagwat", "Bhandari", "Bhardwaj", "Bhargava", "Bhaskar", "Bhattacharya", "Bhattacharjee", "Bhavsar", "Bhide", "Bhonsle", "Bhosale", "Biswas", "Biyani", "Bose", "Budhwar", "Chadha", "Chakrabarti", "Chakraborty", "Chandel", "Chandra", "Chandrasekhar", "Chandran", "Chari", "Chatterjee", "Chaudhari", "Chaudhary", "Chaudhuri", "Chawla", "Chhibber", "Chitnis", "Chopra", "Choudhary", "Choudhury", "Dabholkar", "Dalal", "Dandekar", "Dani", "Das", "Dasgupta", "Dash", "Dave", "Desai", "Deshpande", "Deshmukh", "Devar", "Devi", "Dewan", "Dhar", "Dhawan", "Dholakia", "Dixit", "Dubey", "Dugar", "Dutt", "Dutta", "Dwivedi", "Engineer", "Ezhuthachan", "Fadnavis", "Farooqui", "Gadgil", "Gadre", "Gahlot", "Gairola", "Gaitonde", "Gajjar", "Gandhi", "Ganesh", "Ganguly", "Garg", "Gargesh", "Garud", "Gaur", "Gavaskar", "Ghosh", "Gokhale", "Gopal", "Gopalan", "Goswami", "Goyal", "Guha", "Gupta", "Haldar", "Hegde", "Hiremath", "Hooda", "Iyer", "Iyengar", "Jagtap", "Jain", "Jaitley", "Jani", "Jha", "Jhaveri", "Joshi", "Juyal", "Kadam", "Kailash", "Kaimal", "Kale", "Kamat", "Kamath", "Kanchan", "Kapadia", "Kapoor", "Kapur", "Kar", "Karanth", "Karnik", "Kashyap", "Kaul", "Kaur", "Kedia", "Kelkar", "Khan", "Khanna", "Kharbanda", "Khatri", "Khullar", "Kohli", "Konda", "Kothari", "Koul", "Krishnamurthy", "Kulkarni", "Kumar", "Kurup", "Laghari", "Lala", "Lalwani", "Laxman", "Lokhande", "Luthra", "Madhavan", "Madhur", "Mahajan", "Maharaj", "Maheshwari", "Majumdar", "Malhotra", "Malik", "Mallick", "Malpani", "Mani", "Mannan", "Marathe", "Mathew", "Mehta", "Menon", "Merchant", "Mishra", "Mittal", "Modi", "Mohan", "Mohanty", "Mookerjee", "Mukerjee", "Mukherjee", "Mundra", "Murthy", "Nadar", "Nagarajan", "Nagarkar", "Nair", "Nambiar", "Nanda", "Narayan", "Narayanan", "Nath", "Naudiyal", "Navlakha", "Nayak", "Nigam", "Ojha", "Padmanabhan", "Pahwa", "Pandey", "Pandit", "Pansare", "Pardeshi", "Parikh", "Patel", "Pathak", "Patil", "Patwardhan", "Phadke", "Phadnis", "Pillai", "Poddar", "Pradhan", "Prasad", "Puri", "Purohit", "Raghavan", "Rai", "Raj", "Rajadhyaksha", "Rajagopal", "Rajput", "Ram", "Ramakrishnan", "Ramchandani", "Ramesh", "Rana", "Ranganathan", "Rastogi", "Rath", "Rathore", "Reddy", "Roy", "Sabarwal", "Sabnis", "Sachdev", "Sagar", "Sahai", "Sahni", "Salunkhe", "Samant", "Sampath", "Sanghvi", "Sanyal", "Sarkar", "Sarode", "Saxena", "Sengupta", "Sen", "Setty", "Shah", "Sharma", "Shastri", "Shetty", "Shinde", "Sikdar", "Singh", "Sinha", "Somani", "Srivastava", "Subramanian", "Sudarshan", "Sukhwani", "Sule", "Talwar", "Tandon", "Tendulkar", "Thakur", "Thakuria", "Thakkar", "Thakur", "Tharakan", "Tripathi", "Trivedi", "Upadhyay", "Uppal", "Uttam", "Vaidya", "Varma", "Vats", "Venkatesh", "Verma", "Vyas", "Wadhwa", "Waghela", "Wagle", "Wankhede", "Wani", "Warrier", "Yadav", "Yarlagadda", "Zaveri", "Zutshi", "Anand", "Mehrotra", "Kaushik", "Manohar", "Bhalla", "Mahapatra", "Pattnaik", "Tewari", "Saini", "Baghel", "Jaswal", "Dahiya", "Barthwal", "Godara", "Solanki", "Rawat", "Gill", "Sandhu", "Rao", "Harshvardhan", "Abrol", "Chahal", "Punia", "Kaith", "Chauhan", "Rajoria", "Suri", "Narang", "Kapadia", "Vohra", "Paswan", "Sisodia", "Ahir", "Godse", "Rathod", "Rajoria", "Bajwa", "Chugh", "Dadhwal", "Gaur", "Wadhwani", "Kohar", "Jogi", "Nathani", "Bhatt", "Sambyal", "Gill", "Pannu", "Saigal", "Sobti", "Sood", "Dogra", "Boparai", "Gosain", "Narula", "Mann", "Khurana", "Toor", "Uppal", "Bajaj", "Mathur", "Mudgil", "Jolly", "Sikri", "Thind", "Sethi", "Samra", "Waraich", "Sidhu", "Sagar", "Bhalla", "Batth", "Bagri", "Banga", "Gandotra", "Parmar", "Dhawan", "Punia", "Tandon", "Tomar", "Chug", "Bhasin", "Khungar", "Mohanty", "Basak", "Bandyopadhyay", "Talukdar", "Banerjee", "Dey", "Lahiri", "Dutta", "Datta", "Chattopadhyay", "Bhattacharya", "Mukhopadhyay", "Das", "Bhowmik", "Basu", "Roych", "dhury", "Ganguly", "Majumdar", "Sengupta", "Chakraborty", "Saha", "Bhatt", "Mitra", "Bagchi", "Chatterjee", "Bhaduri", "Deb", "Pramanik", "Sarkar", "Pal", "Guha", "Lodh", "Sen", "Haldar", "Ray", "Bhattacharya", "Bose", "Ghosal", "Bhattacharjee", "Kanjilal", "Shome", "Lahiri", "Biswas", "Mullick", "Nag", "Basu", "Nandi", "Chattopadhyay", "Dasgupta", "Chaudhuri", "Paul", "Rakshit", "Guhathakurta", "Bagchi", "Maji", "Sanyal", "Kar", "Kashyap", "Patowary", "Choudhury", "Mandal", "Sil", "Kumar", "Pandey", "Raj", "Singh", "Thakur", "Verma", "Sharma", "Gupta", "Yadav", "Rana", "Pathak", "Chauhan", "Arya", "Srivastava", "Pandit", "Rajput", "Rathore", "Mishra", "Dubey", "Awasthi", "Dwivedi", "Shukla", "Jaiswal", "Trivedi", "Tiwari", "Nigam", "Dixit", "Bhatt", "Upadhyay"};

        int randomIndex = random.nextInt(lastNames.length);
        return lastNames[randomIndex];

    }


    String getGender() {
        String[] gender = {"Male", "Female"};
        return gender[random.nextInt(gender.length)];
    }


    String getMaleEmail(String firstName, String lastName) {
        String[] domains = {"gmail.com", "yahoo.com", "outlook.com", "hotmail.com", "yahoo.com", "myyahoo.com"};

        String domain = domains[random.nextInt(domains.length)];

        int randomNumber = 0 + random.nextInt(900); // Generates a number between 100 and 999


        String[] email = {firstName.toLowerCase() + "." + lastName.toLowerCase() + randomNumber + "@" + domain, lastName.toLowerCase() + "." + firstName.toLowerCase() + randomNumber + "@" + domain};
        return email[random.nextInt(email.length)];
    }


    String getFemaleEmail(String firstName, String lastName) {
        String[] domains = {"gmail.com", "yahoo.com", "outlook.com", "hotmail.com", "yahoo.com", "myyahoo.com"};

        String domain = domains[random.nextInt(domains.length)];

        int randomNumber = 0 + random.nextInt(900); // Generates a number between 100 and 999

        String[] email = {firstName.toLowerCase() + "." + lastName.toLowerCase() + randomNumber + "@" + domain, lastName.toLowerCase() + "." + firstName.toLowerCase() + randomNumber + "@" + domain};
        return email[random.nextInt(email.length)];
    }

    long getPhone() {
        String[] mobilePrefixes = {"6", "7", "8", "9"};
        Random random = new Random();

        long randomMobileNumber = 100000000L + random.nextInt(900000000);

        String mobilePrefix = mobilePrefixes[random.nextInt(mobilePrefixes.length)];
        long mobile = Long.parseLong(mobilePrefix + randomMobileNumber);
        return mobile;
    }

    String getDateOfBirth() {
        int year = random.nextInt(7) + 2005; // 2005 to 2011

        int month = random.nextInt(12) + 1; // 1 to 12

        int day = getRandomDayOfMonth(year, month);

        String dob = String.format("%02d-%02d-%04d", day, month, year);
        return dob;
    }

    private int getRandomDayOfMonth(int year, int month) {
        int maxDay = 0;

        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12:
                maxDay = 31;
                break;
            case 4, 6, 9, 11:
                maxDay = 30;
                break;
            case 2:
                maxDay = (isLeapYear(year)) ? 29 : 28;
                break;
        }
        return random.nextInt(maxDay) + 1;
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }


    long getAadharNumber() {
        StringBuilder sb = new StringBuilder();

        // Generate the first digit separately, ensuring it is not 0
        int firstDigit = random.nextInt(9) + 1;
        sb.append(firstDigit);

        // Generate the remaining digits
        for (int i = 1; i < 16; i++) {
            int digit = random.nextInt(10);
            sb.append(digit);
        }
        return Long.parseLong(sb.toString());
    }

    long getVidNumber() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 12; i++) {
            int digit = random.nextInt(10);
            sb.append(digit);
        }
        return Long.parseLong(sb.toString());

    }

    String getPanNumber() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            char randomChar = (char) (random.nextInt(26) + 'A');
            sb.append(randomChar);
        }

        for (int i = 0; i < 4; i++) {
            int randomDigit = random.nextInt(10);
            sb.append(randomDigit);
        }

        for (int i = 0; i < 2; i++) {
            char randomChar = (char) (random.nextInt(26) + 'A');
            sb.append(randomChar);
        }

        return sb.toString();
    }

    Long getRoll() {
        String yearPrefix = "2024";

        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int randomDigit = random.nextInt(10);
            sb.append(randomDigit);
        }

        String numericString = yearPrefix + sb.toString();

        return Long.parseLong(numericString);
    }


    String getCountry() {

        String[] arr = {"India", "United States", "Canada", "Australia", "United Kingdom", "Germany", "France", "Italy", "Spain", "China", "Japan", "South Korea", "Brazil", "Mexico", "Russia", "South Africa", "New Zealand", "Argentina", "Sweden", "Norway"};

        int randomIndex = random.nextInt(arr.length);
        return arr[randomIndex];


    }


    public String getId(String s1) {

        final String ALPHABET = "ABCDEFGHJKLMNPQRSTUVWXYZ";
        final String DIGITS = "123456789";
        final Random RANDOM = new Random();


        StringBuilder sb = new StringBuilder();
        sb.append(s1);


        for (int i = 0; i < 3; i++) {
            sb.append(DIGITS.charAt(RANDOM.nextInt(DIGITS.length())));
        }

        for (int i = 0; i < 2; i++) {
            sb.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }


        return sb.toString();

    }

    public List<PersonalData> generateMultipleMaleData(int count) {
        List<PersonalData> personalDataList = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            personalDataList.add(generateMaleData());
        }
        return personalDataList;
    }

    public List<PersonalData> generateMultipleFemaleData(int count) {
        List<PersonalData> personalDataList = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            personalDataList.add(generateMaleData());
        }
        return personalDataList;
    }


    PersonalData generateMaleData() {

        Microservices microservices = new Microservices();


        PersonalData personalData = new PersonalData();

        String id;
        do {
            id = microservices.getId("PERSNL"); // Generate a new ID
        } while (dao.existsById(id));

        personalData.setPersonal_Id(id);

        personalData.setPhone(BigInteger.valueOf(microservices.getPhone()));
        personalData.setDate_Of_Birth(microservices.getDateOfBirth());

        personalData.setAadhar_Number(BigInteger.valueOf(microservices.getAadharNumber()));
        personalData.setVid(BigInteger.valueOf(microservices.getVidNumber()));
        personalData.setPan_Number(microservices.getPanNumber());

        personalData.setCountry_Name(microservices.getCountry());

        personalData.setGender("Male");

        String first_name = microservices.getMaleFirstName();

        String last_name = microservices.getMaleLastName();


        personalData.setFirst_name(first_name);
        personalData.setLast_name(last_name);

        String father_first_name = microservices.getMaleFirstName();
        String father_last_name = microservices.getMaleLastName();


        while (first_name.equalsIgnoreCase(father_first_name)) {
            father_first_name = microservices.getMaleFirstName();
        }

        while (last_name.equalsIgnoreCase(father_last_name)) {
            father_last_name = microservices.getMaleLastName();
        }

        personalData.setFather_First_Name(father_first_name);
        personalData.setFather_Last_Name(father_last_name);


        personalData.setMother_First_Name(microservices.getFemaleFirstName());
        personalData.setMother_Last_Name(microservices.getFemaleLastName());

        personalData.setEmail(microservices.getMaleEmail(first_name, last_name));

        return personalData;

    }

    PersonalData generateFemaleData() {

        Microservices microservices = new Microservices();


        PersonalData personalData = new PersonalData();


        String id;
        do {
            id = microservices.getId("PERSNL"); // Generate a new ID
        } while (dao.existsById(id));

        personalData.setPersonal_Id(id);

        personalData.setPhone(BigInteger.valueOf(microservices.getPhone()));
        personalData.setDate_Of_Birth(microservices.getDateOfBirth());

        personalData.setAadhar_Number(BigInteger.valueOf(microservices.getAadharNumber()));
        personalData.setVid(BigInteger.valueOf(microservices.getVidNumber()));
        personalData.setPan_Number(microservices.getPanNumber());

        personalData.setCountry_Name(microservices.getCountry());

        personalData.setGender("Female");

        String first_name = microservices.getFemaleFirstName();

        String last_name = microservices.getFemaleLastName();


        personalData.setFirst_name(first_name);
        personalData.setLast_name(last_name);


        personalData.setFather_First_Name(microservices.getMaleFirstName());
        personalData.setFather_Last_Name(microservices.getMaleLastName());

        String mother_first_name = microservices.getFemaleFirstName();
        String mother_last_name = microservices.getFemaleLastName();


        while (first_name.equalsIgnoreCase(mother_first_name)) {
            mother_first_name = microservices.getFemaleFirstName();
        }

        while (last_name.equalsIgnoreCase(mother_last_name)) {
            mother_last_name = microservices.getFemaleLastName();
        }

        personalData.setMother_Last_Name(mother_last_name);
        personalData.setMother_First_Name(mother_first_name);


        personalData.setEmail(microservices.getFemaleEmail(first_name, last_name));


        return personalData;


    }


}