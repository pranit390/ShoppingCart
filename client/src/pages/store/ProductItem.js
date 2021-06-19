import React, { useContext } from 'react';
import { Link } from 'react-router-dom';
import { formatNumber } from '../../helpers/utils';
import axios from "axios";
const ProductItem = ({product}) => {

 
    
   
     const addToCart=async(id)=>{
     
        const todos = await axios.post(`http://localhost:8080/api/addtocart/addProduct?productId=${id}&userId=1&qty=1`)
       console.log(todos)
       if(todos.data.message=="Added to cart")
       {alert("Item added")}
       
        if(todos.data.message=="ProductNotFound")
       {alert("Already Exist In cart")}
     
        
     
    }


   

    return ( 
        <div className="card card-body">
           
            <p>{product.productName==='Book'?<div><p>{product.bookGenre}</p><p>{product.bookAuthor}</p><p>{product.bookPublications}</p></div>:
         <div><p>{product.appralBrand}</p><p>{product.appralDesign}</p><p>{product.appralType}</p></div>}</p>
             
            <h3 className="text-left">{formatNumber(product.productPrice)}</h3>
            <div className="text-right">
                <Link  to="/" className="btn btn-link btn-sm mr-2">Details</Link>


                {
                   
                    <button 
                    onClick={() => addToCart(product.productId)}
                    className="btn btn-primary btn-sm">Add to cart</button>
                }
                
            </div>
        </div>
     );
}
 
export default ProductItem;