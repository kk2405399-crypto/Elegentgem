// Mobile Navigation Toggle
const hamburger = document.querySelector('.hamburger');
const navMenu = document.querySelector('.nav-menu');

hamburger.addEventListener('click', () => {
    hamburger.classList.toggle('active');
    navMenu.classList.toggle('active');
});

// Close mobile menu when clicking on a link
document.querySelectorAll('.nav-menu a').forEach(link => {
    link.addEventListener('click', () => {
        hamburger.classList.remove('active');
        navMenu.classList.remove('active');
    });
});

// Collections Data
const collections = [
    {
        id: 1,
        name: "Celestial Dreams Necklace",
        description: "A cascade of starlight captured in gold, designed to make you shine like the stars.",
        price: "PKR 45,000",
        icon: "fas fa-star"
    },
    {
        id: 2,
        name: "Eternal Glow Earrings",
        description: "Delicate drops of pure elegance that whisper sophistication with every movement.",
        price: "PKR 28,000",
        icon: "fas fa-gem"
    },
    {
        id: 3,
        name: "Royal Heritage Ring",
        description: "Timeless craftsmanship meets modern luxury in this statement piece fit for royalty.",
        price: "PKR 38,000",
        icon: "fas fa-crown"
    },
    {
        id: 4,
        name: "Moonlit Bracelet",
        description: "Graceful curves of gold that embrace your wrist like moonlight on water.",
        price: "PKR 32,000",
        icon: "fas fa-moon"
    },
    {
        id: 5,
        name: "Aurora Pendant",
        description: "A mesmerizing gem that captures the magic of northern lights in precious metal.",
        price: "PKR 42,000",
        icon: "fas fa-snowflake"
    },
    {
        id: 6,
        name: "Diamond Whisper Set",
        description: "A harmonious collection that speaks volumes in the language of luxury.",
        price: "PKR 65,000",
        icon: "fas fa-diamond"
    },
    {
        id: 7,
        name: "Vintage Rose Brooch",
        description: "Classic elegance reimagined with intricate details that tell a story of timeless beauty.",
        price: "PKR 25,000",
        icon: "fas fa-feather-alt"
    },
    {
        id: 8,
        name: "Infinity Love Bangle",
        description: "Endless circles of devotion crafted in the finest gold for eternal moments.",
        price: "PKR 36,000",
        icon: "fas fa-infinity"
    }
];

// Function to create collection cards
function createCollectionCard(collection) {
    return `
        <div class="collection-card">
            <div class="collection-img">
                <i class="${collection.icon}"></i>
            </div>
            <div class="collection-content">
                <h3>${collection.name}</h3>
                <p>${collection.description}</p>
                <div class="collection-price">${collection.price}</div>
            </div>
        </div>
    `;
}

// Load collections on page load
document.addEventListener('DOMContentLoaded', function() {
    const collectionsGrid = document.querySelector('.collections-grid');
    
    if (collectionsGrid) {
        collectionsGrid.innerHTML = collections.map(createCollectionCard).join('');
    }
    
    // Add scroll effect to header
    window.addEventListener('scroll', function() {
        const header = document.querySelector('.header');
        if (window.scrollY > 100) {
            header.style.boxShadow = '0 5px 15px rgba(0, 0, 0, 0.1)';
        } else {
            header.style.boxShadow = '0 2px 10px rgba(0, 0, 0, 0.05)';
        }
    });
    
    // Add animation to collection cards on scroll
    const observerOptions = {
        threshold: 0.1,
        rootMargin: '0px 0px -50px 0px'
    };
    
    const observer = new IntersectionObserver(function(entries) {
        entries.forEach(entry => {
            if (entry.isIntersecting) {
                entry.target.classList.add('animate');
            }
        });
    }, observerOptions);
    
    // Observe collection cards
    document.querySelectorAll('.collection-card').forEach(card => {
        observer.observe(card);
    });
    
    // Smooth scroll for anchor links
    document.querySelectorAll('a[href^="#"]').forEach(anchor => {
        anchor.addEventListener('click', function(e) {
            e.preventDefault();
            
            const targetId = this.getAttribute('href');
            if (targetId === '#') return;
            
            const targetElement = document.querySelector(targetId);
            if (targetElement) {
                window.scrollTo({
                    top: targetElement.offsetTop - 80,
                    behavior: 'smooth'
                });
            }
        });
    });
});
