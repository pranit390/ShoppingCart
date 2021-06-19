import React, { useContext,useEffect ,useState} from 'react';
import ProductItem from './ProductItem';
import styles from './ProductsGrid.module.scss';
import axios from "axios";

const ProductsGrid = () => {

  
    
    const [todos, setTodos] = useState([])
    
    useEffect(() => {
      const fetchTodoAndSetTodos = async () => {
      const todos =  await axios.get("http://localhost:8080/api/product/getProducts")
        setTodos(todos.data.list)
      }
      fetchTodoAndSetTodos()
    }, [])
    
  

    return ( 
        <div className={styles.p__container}>
            <div className="row">
                <div className="col-sm-8">
                    <div className="py-3">
                        {todos.length} Products
                    </div>
                </div>
                <div className="col-sm-4">
                    <div className="form-group">
                        <input type="text" name="" placeholder="Search product" className="form-control" id=""/>
                    </div>
                </div>
            </div>
            <div className={styles.p__grid}>

                {
                    todos.map(product => (
                        <ProductItem key={product.id} product={product}/>
                    ))
                }

            </div>
            <div className={styles.p__footer}>

            </div>
        </div>
     );
}
 
export default ProductsGrid;