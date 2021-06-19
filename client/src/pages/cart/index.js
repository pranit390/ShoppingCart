/* eslint-disable no-undef */
import React, { useContext,useEffect,useState } from 'react';
import Layout from '../../components/Layout';
import styles from './CartProducts.module.scss';

import { PlusCircleIcon, MinusCircleIcon, TrashIcon } from '../../components/icons'
import { CartContext } from '../../contexts/CartContext';
import { formatNumber } from '../../helpers/utils';
import { Link } from 'react-router-dom';
import axios from "axios";
const Cart = () => {

   const { clearCart, checkout, handleCheckout } = useContext(CartContext);
   
    const [todos, setTodo] =useState([]);
    
    
     useEffect(() => {
      const fetchTodoAndSetTodos = async () => {
     
    
      const todo =  await axios.get("http://localhost:8080/api/addtocart/getCartsByUserId?userId=1")
      setTodo(todo.data.list);
       
      }
      fetchTodoAndSetTodos()
    }, [])
     
     
      const increaseCart=async (cartId,qty)=>{
	
    
    const list =await axios.put(`http://localhost:8080/api/addtocart/updateQtyForCart?cartId=${cartId}&qty=${qty}&userId=1`);
       setTodo(list.data.list);
      
    }
    
      const removeCart=async(id)=>{
     
        const todos = await axios.delete(`http://localhost:8080/api/addtocart/removeProductFromCart?cartId=${id}&userId=1`)
        
     setTodo(todos.data.list);
    }
    
     const removeEntireCart=async()=>{
     
        const todos = await axios.delete(`http://localhost:8080/api/addtocart/removeAllProductFromCart?userId=1`)
        setTodo(todos.data.list);
     
     handleCheckout();
    }
 
    let sum=0;
    todos.map(function(x){sum+=x.product.productPrice*x.quantity});
    return ( 
        <Layout title="Cart" description="This is the Cart page" >
            <div >
                <div className="text-center mt-5">
                    <h1>Cart</h1>
                    <p>This is the Cart Page.</p>
                </div>

                <div className="row no-gutters justify-content-center">
                    <div className="col-sm-9 p-3">
                        {
                            todos.length > 0 ?
                           ( 
        <div className={styles.p__container}>
            <div className="card card-body border-0">

                {
                    todos.map((product,i) =>  ( 
        <div className="row no-gutters py-2">
            <div className="col-sm-2 p-2">
                
            <p>{product.product.productName==='Book'?<div><p>{product.product.bookGenre}</p><p>{product.product.bookAuthor}</p><p>{product.product.bookPublications}</p></div>:
         <div><p>{product.product.appralBrand}</p><p>{product.product.appralDesign}</p><p>{product.product.appralType}</p></div>}</p>
             
            </div>
            <div className="col-sm-4 p-2">
                <h5 className="mb-1">{product.name}</h5>
                <p className="mb-1">Price: {formatNumber(product.product.productPrice)} </p>
                
            </div>
            <div className="col-sm-2 p-2 text-center ">
                 <p className="mb-0">Qty: {product.quantity}</p>
            </div>
            <div className="col-sm-4 p-2 text-right">
                 <button 
                 onClick={()=> increaseCart(product.id,product.quantity+1)}
                 className="btn btn-primary btn-sm mr-2 mb-1">
                     <PlusCircleIcon width={"20px"}/>
                 </button>

                 {
                     <button
                    onClick={() => increaseCart(product.id,product.quantity-1)}
                    className="btn btn-danger btn-sm mb-1">
                        <MinusCircleIcon width={"20px"}/>
                    </button>
                 }

                {
                     
                     <button
                    onClick={() => removeCart(product.id)}
                    className="btn btn-danger btn-sm mb-1">
                        <TrashIcon width={"20px"}/>
                    </button>
                 }
                 
            </div>
        </div>
     ))
                }

            </div>
        </div>

     ) :
                            <div className="p-3 text-center text-muted">
                                Your cart is empty
                            </div>
                        }

                        { checkout && 
                            <div className="p-3 text-center text-success">
                                <p>Checkout successfull</p>
                                <Link to="/" className="btn btn-outline-success btn-sm">BUY MORE</Link>
                            </div>
                        }
                    </div>
                    {
                        todos.length > 0 && 
                        <div className="col-sm-3 p-3">
                            <div className="card card-body">
                                <p className="mb-1">Total Items</p>
                                <h4 className=" mb-3 txt-right">{todos.length}</h4>
                                <p className="mb-1">Total Payment</p>
                                <h3 className="m-0 txt-right">{sum}</h3>
                                <hr className="my-4"/>
                                <div className="text-center">
                                    <button type="button" className="btn btn-primary mb-2" onClick={removeEntireCart}>CHECKOUT</button>
                                    <button type="button" className="btn btn-outlineprimary btn-sm" onClick={removeEntireCart}>CLEAR</button>
                                </div>

                            </div>
                        </div>
                    }
                    
                </div>
            </div>
        </Layout>
     );
}
 
export default Cart;