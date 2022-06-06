import ProductImg from 'assets/images/bolo.jpeg';
import ProductPrice from 'components/ProductPrice';

import './styles.css';

const ProductCard = () => {

    return (
        <div className="base-card product-card">
            <div className="card-top-container">
                <img src={ProductImg} alt="Bolo de cenoura com cobertura de chocolate" />
            </div>
            <div className="card-bottom-container">
                <h6>Nome do produto</h6>
                <ProductPrice />
            </div>
        </div>
    )

}

export default ProductCard;