import { Dialog, DialogContent } from "@mui/material"
export default function PDFModal ({ isOpen, closeModal, pdfUrl}) {
    return(
            <Dialog 
            open={isOpen}
            onClose={closeModal}
            sx={{borderRadius: 30, height: '90vh', width: '90vh', overflow: 'scroll', padding: 0}}>
                <DialogContent sx={{padding: 0, margin: 0}}>
                    <iframe title="PDF Viewer" src={pdfUrl} width="100%" height="100%" style={{overflow: 'scroll'}}/>
                </DialogContent>
            </Dialog>
    );
}