import React, { Component } from 'react'
import axios from 'axios'
import ShowFood from './ShowFood'
import './SearchFood.css'
import r1 from "./images/orange.jpg";
import r2 from "./images/pomo.jpg";
import r3 from "./images/lychee.jpg";
import r4 from "./images/apple.jpg";
import r5 from "./images/mango.jpg";
import r6 from "./images/banana.jpg";
import r7 from "./images/watermelon.jpg";
import r8 from "./images/grapes.jpg";
import r9 from "./images/guava.jpg";
import apple from "./images/apple.webp";
import ab from "./images/ab.jpg";


export default class ShowList extends Component {
    //To store foods data
    state = {
        foods: [
        ],
        foodType:[

        ],
        recommend:[]
    }

    handleAddRecommendedFood=(e,inputQuery)=>{

        console.log(inputQuery);
        const recommendedfood = {
            fdcId: e.fdcId,
            description: e.description,
            dataType: e.dataType,
            foodType: inputQuery,
            foodNutrients: e.foodNutrients.slice(0, 20)
        }

        //User's emailId
        const emailId = localStorage.getItem("emailId");
        //JWT Token
        const token = localStorage.getItem("token");
        //REST API url to send post request
        const api_url = `http://localhost:9010/recommended/users/${emailId}`

        //POST to backend Favourite Rest Service
        axios.post(api_url, recommendedfood,
            {
                headers: {
                    Authorization: `Bearer ${token}`, 'Access-Control-Allow-Origin': '*',
                    'Content-Type': 'application/json'
                }
            })
            .then(res => {
              //  alert("Food added successfully");
            })
            .catch(e => {
                axios.put(api_url, recommendedfood,
                    {
                        headers: {
                            Authorization: `Bearer ${token}`, 'Access-Control-Allow-Origin': '*',
                            'Content-Type': 'application/json'
                        }
                    })
                    .then(res => {
                       // alert("Food added successfully");
                    })
                    .catch(e => {
                       // alert("Food Already added to Favourites ");
                    })
            })



    }
    //Method to handle click on search button 
    handleClick = () => {
        const inputQuery = document.getElementById("inputQuery").value;
        const sortByValue = document.getElementById("sortBy").value;
        //Query parameter to sort foods array on the basis of that field
        let sortBy;
        switch (sortByValue) {
            case "FDC Id":
                sortBy = "fdcId";
                break;
            case "Published Date":
                sortBy = "publishedDate";
                break;
            default:
                sortBy = ""
                break;
        }

        //FoodData Central API endpoint
        //Returns a list of foods that matched search (query) keywords
        const api_url = `https://api.nal.usda.gov/fdc/v1/foods/search?api_key=dFrdgMew7Q38CHY4JM4QB0HeTWBuvCO1jOqXa0Ec&query=${inputQuery}&sortBy=${sortBy}&sortOrder=asc`

        //Using to axios to get data from api
        axios.get(api_url)
            .then(res => {
                //Stroing response into state
                if(res.data.foods.length === 0)
                alert("Try different keyword");
                const newIndex = Math.floor(Math.random() * res.data.foods.length);
                console.log(res.data.foods[newIndex]);

                this.setState({ foods: res.data.foods,foodType:{inputQuery}, recommend: res.data.foods[newIndex]});
               console.log(this.state.recommend);
               this.handleAddRecommendedFood(this.state.recommend,inputQuery);
            })

           

    }

    render() {
        return (
            <div className="search-body">
                <div className="search-shade">
                <p className="h1 text-left p-5 text-white-50 font-weight-bold">Search Food</p>
                <div className="container pt-5">
                    <div className="row pl-5 pr-5">
                        <div className="col-md-8 mb-3">
                            <label htmlFor="inputQuery" className="h3 text-white font-weight-bold">Food Item</label>
                            <input type="text" className="form-control" id="inputQuery" name="inputQuery" placeholder="Enter food to search" />
                        </div>
                        <div className="col-md-4">
                            <label htmlFor="sortBy" className="h3 text-white font-weight-bold">Sort By</label>
                            <select className="form-control" id="sortBy" name="sortBy">
                                <option>FDC Id</option>
                                <option>Published Date</option>
                            </select>
                        </div>

                    </div>
                    
                    <div className="row d-flex justify-content-center ">
                        <button className="btn btn-success btn-lg  my-4" onClick={this.handleClick}>Search</button>
                    </div>
                </div>

                <div className="container">
                    {   
                        //Mapping each food returns are query result
                        this.state.foods.map((item,i) => (
                            <ShowFood key={i} foodItem={item} foodf={this.state.foodType}/>
                        ))
                    }
                    </div>
                </div>
                <div className="container-fluid">
                    <div className="text-center p-3"></div>    
                    <div className="row">
                        <div className="col-md-4">
                            <img className="rounded" src={r4} alt="" />
                            <button>view more</button>
                        </div>
                        <div className="col-md-4">
                            <img className="rounded" src={r5} alt="" />
                            <button>view more</button>
                        </div>
                        <div className="col-md-4">
                            <img className="rounded" src={r6} alt="" />
                            <button>view more</button>
                        </div>
                        </div>
                        
                        <div className="text-center p-3"></div>    
                    <div className="row">
                        <div className="col-md-4">
                            <img className="rounded" src={r1} alt="" />
                            <button>view more</button>
                        </div>
                        <div className="col-md-4">
                            <img className="rounded" src={r2} alt="" />
                            <button>view more</button>
                        </div>
                        <div className="col-md-4">
                            <img className="rounded" src={r3} alt="" />
                            <button>view more</button>
                        </div>
                        </div>

                        <div className="text-center p-3"></div>    
                    <div className="row">
                        <div className="col-md-4">
                            <img className="rounded" src={r7} alt="" />
                            <button>view more</button>
                        </div>
                        <div className="col-md-4">
                            <img className="rounded" src={r8} alt="" />
                            <button>view more</button>
                        </div>
                        <div className="col-md-4">
                            <img className="rounded" src={r9} alt="" />
                            <button>view more</button>
                        </div>
                        </div>
                        <div className="text-center p-5">
                        
                        </div>                      
                </div>
                
            </div>


        )
    }
}
