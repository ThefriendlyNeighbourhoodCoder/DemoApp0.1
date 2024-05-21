const allSideMenu = document.querySelectorAll('#sidebar .side-menu.top li a');
const menuBar = document.querySelector('#content nav .bx.bx-menu');
const sidebar = document.getElementById('sidebar');

// Function to expand the sidebar
function expandSidebar() {
    if (sidebar.classList.contains('hide')) {
        sidebar.classList.remove('hide');
    }
}

// Function to collapse the sidebar
function collapseSidebar() {
    if (!sidebar.classList.contains('hide')) {
        sidebar.classList.add('hiding'); // Add class for transition delay
        setTimeout(() => {
            sidebar.classList.add('hide');
            sidebar.classList.remove('hiding'); // Remove class after transition delay
        }, 50); // Wait for the transition to complete before hiding (adjust as needed)
    }
}

allSideMenu.forEach(item => {
    item.addEventListener('click', function () {
        collapseSidebar(); // Collapse sidebar before expanding
        expandSidebar(); // Then expand sidebar
        // Add your logic for menu item click
        const li = item.parentElement;
        allSideMenu.forEach(i => {
            i.parentElement.classList.remove('active');
        });
        li.classList.add('active');
    });
});

// Close sidebar when clicking outside of it
document.addEventListener('click', function(event) {
    if (!sidebar.contains(event.target) && !menuBar.contains(event.target)) {
        collapseSidebar(); 
    }
});

// TOGGLE SIDEBAR
menuBar.addEventListener('click', function () {
    sidebar.classList.toggle('hide');
});









const searchButton = document.querySelector('#content nav form .form-input button');
const searchButtonIcon = document.querySelector('#content nav form .form-input button .bx');
const searchForm = document.querySelector('#content nav form');

searchButton.addEventListener('click', function (e) {
	if(window.innerWidth < 576) {
		e.preventDefault();
		searchForm.classList.toggle('show');
		if(searchForm.classList.contains('show')) {
			searchButtonIcon.classList.replace('bx-search', 'bx-x');
		} else {
			searchButtonIcon.classList.replace('bx-x', 'bx-search');
		}
	}
})





if(window.innerWidth < 768) {
	sidebar.classList.add('hide');
} else if(window.innerWidth > 576) {
	searchButtonIcon.classList.replace('bx-x', 'bx-search');
	searchForm.classList.remove('show');
}


window.addEventListener('resize', function () {
	if(this.innerWidth > 576) {
		searchButtonIcon.classList.replace('bx-x', 'bx-search');
		searchForm.classList.remove('show');
	}
})



const switchMode = document.getElementById('switch-mode');

switchMode.addEventListener('change', function () {
	if(this.checked) {
		document.body.classList.add('dark');
	} else {
		document.body.classList.remove('dark');
	}
})

